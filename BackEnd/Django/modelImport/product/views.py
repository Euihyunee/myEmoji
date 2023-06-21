from PIL import Image
from django.http import FileResponse, HttpResponse, HttpResponseNotFound
from rest_framework.response import Response
from rest_framework.views import APIView
from .models import *
from .serializers import *
import base64
from io import BytesIO


def check(request):
    return HttpResponse("hihi")

def test_reqeust(request):
    return HttpResponse("success!");

# 스프링에서 요청 -> requestid, {img_url, tag_name} 받아 -> AI 돌려
# DB에 (tag_name1, img_url, img, requestid), (tag_name2, img_url, img, requestid)... 저장
class PictureAPI(APIView):
    def get(self, request, rq_id):
        queryset = Style.objects.filter(request_id=rq_id)
        serializer = StyleSerializer(queryset, many=True)
        return Response(serializer.data)


# 스프링에서 요청 -> requestid, tag_name, emoji_url, emoji_tag 줘
class EmojiAPI(APIView):
    def get(self, request, rq_id):
        queryset = Emoji.objects.filter(request_id=rq_id)
        serializer = EmojiSerializer(queryset, many=True)
        return Response(serializer.data)

def stable(request, rq_id, paint):
    # pix2pix
    import PIL
    import requests
    import torch
    from diffusers import StableDiffusionInstructPix2PixPipeline
    from enum import Enum

    class Prompt(Enum):
        a = "smile"
        b = "angry"
        c = "add a heart emoji"
        d = "sad"
        e = "yawn"

    class Style_p(Enum):
        gogh = "goth painting style"
        sketch = "sketch"
        cartoon = "cartoon style"

    model_id = "timbrooks/instruct-pix2pix"
    pipe = StableDiffusionInstructPix2PixPipeline.from_pretrained(model_id, torch_dtype=torch.float16).to("cuda")

    url = "https://search.pstatic.net/sunny/?src=https%3A%2F%2Fmusicimage.xboxlive.com%2Fcatalog%2Fvideo.contributor.c41c6500-0200-11db-89ca-0019b92a3933%2Fimage%3Flocale%3Den-us%26target%3Dcircle&type=sc960_832"

    def download_image(url):
        image = PIL.Image.open(requests.get(url, stream=True).raw)
        image = PIL.ImageOps.exif_transpose(image)
        image = image.convert("RGB")
        return image

    image = download_image(url)

    for s in Style_p:
        if s.name == paint:
            t_name = s.value

    for i in range(1, 4):
        for p in Prompt:
            prompt = str(p.value) + str(t_name)
            images = pipe(prompt, image=image, num_inference_steps=20, image_guidance_scale=1.5,
                          guidance_scale=7).images
            images[0].save("stable_pix2pix.png")
            img = open("stable_pix2pix.png", "rb")

            e_name = p.value
            img = base64.b64encode(img.read())
            url = "localhost:8000/showEmoji/" + rq_id + "/" + t_name + "/" + e_name + "/" + str(i)

            test = Emoji(request_id=rq_id, tag_name=t_name, emoji_tag=e_name, emoji_url=url, emoji=img, set_num=i)
            test.save()

    return HttpResponse("emoji")

def style(request, rq_id):
    import PIL
    import requests
    import torch
    from diffusers import StableDiffusionInstructPix2PixPipeline
    from enum import Enum

    class Painting(Enum):
        gogh = "goth painting style"
        sketch = "sketch"
        cartoon = "cartoon style"

    model_id = "timbrooks/instruct-pix2pix"
    pipe = StableDiffusionInstructPix2PixPipeline.from_pretrained(model_id, torch_dtype=torch.float16).to("cuda")

    url = "https://search.pstatic.net/sunny/?src=https%3A%2F%2Fmusicimage.xboxlive.com%2Fcatalog%2Fvideo.contributor.c41c6500-0200-11db-89ca-0019b92a3933%2Fimage%3Flocale%3Den-us%26target%3Dcircle&type=sc960_832"

    def download_image(url):
        image = PIL.Image.open(requests.get(url, stream=True).raw)
        image = PIL.ImageOps.exif_transpose(image)
        image = image.convert("RGB")
        return image

    image = download_image(url)

    for p in Painting:
        prompt = str(p.value)
        images = pipe(prompt, image=image, num_inference_steps=20, image_guidance_scale=1.5, guidance_scale=7).images
        images[0].save("paintingStyle.png")
        img = open("paintingStyle.png", "rb")

        t_name = p.value
        img = base64.b64encode(img.read())
        url = "localhost:8000/showImg/" + rq_id + "/" + t_name

        painting = Style(request_id=rq_id, tag_name=t_name, img_url=url, img=img)
        painting.save()

    return HttpResponse("style")


def show_img(request, rq_id, t_name):
    styles = Style.objects.filter(request_id=rq_id, tag_name=t_name).values("img")
    if styles.exists():
        base_string = styles.first()['img']
        img = Image.open(BytesIO(base64.b64decode(base_string)))

        if img.format == "JPEG":
            c_type = "image/jpeg"
        elif img.format == "PNG":
            c_type = "image/png"
        else:
            return HttpResponseNotFound("Unsupported image foramt")

        response = HttpResponse(content_type=c_type)
        img.save(response, format=img.format)
        return response
    else:
        return HttpResponseNotFound("Image not found")


def show_emoji(request, rq_id, t_name, e_name, s_num):
    emojis = Emoji.objects.filter(request_id=rq_id, tag_name=t_name, emoji_tag=e_name, set_num=int(s_num)).values("emoji")
    if emojis.exists():
        base_string = emojis.first()['emoji']
        img = Image.open(BytesIO(base64.b64decode(base_string)))

        if img.format == "JPEG":
            c_type = "image/jpeg"
        elif img.format == "PNG":
            c_type = "image/png"
        else:
            return HttpResponseNotFound("Unsupported image foramt")

        response = HttpResponse(content_type=c_type)
        img.save(response, format=img.format)
        return response
    else:
        return HttpResponseNotFound("Image not found")
