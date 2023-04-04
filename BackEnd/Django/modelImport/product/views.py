from django.http import HttpResponse, FileResponse
from django.shortcuts import render
from rest_framework.response import Response
from .models import Product
from rest_framework.views import APIView
from .serializers import ProductSerializer

from diffusers import StableDiffusionPipeline
import torch


class ProductListAPI(APIView):
    def get(self, request):
        queryset = Product.objects.all()
        print(queryset)
        serializer = ProductSerializer(queryset, many=True)
        return Response(serializer.data)


def stable(request):
    pipe = StableDiffusionPipeline.from_pretrained("CompVis/stable-diffusion-v1-4", torch_dtype=torch.float16)
    pipe = pipe.to("cuda")
    prompt = "happy man"

    image = pipe(prompt).images[0]
    image.save(f"a_r_h.png")

    img = open('a_r_h.png', 'rb')
    response = FileResponse(img)
    return response
