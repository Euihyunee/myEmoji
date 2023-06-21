package com.emojiMaker.BackEnd.Controller;

import com.emojiMaker.BackEnd.Model.DTO.newDTO.RequestTagDTO;
import com.emojiMaker.BackEnd.Model.UrlMakeClass;
import com.emojiMaker.BackEnd.Service.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/image")
@CrossOrigin("*")
public class ImageController {

    @Autowired
    ImageService imageService;
    UrlMakeClass urlMakeClass = new UrlMakeClass();

// TODO img 들어옴
    @PostMapping("/upload")
    public String requestPhoto(@RequestPart MultipartFile imgFile) throws IOException {
        // TODO 파일명, requestId 필요함
        RequestTagDTO requestTagDTO = imageService.uploadImg(imgFile);
        // TODO Tag 요청 URL : Get방식, /{requestId}/{imgName}
        String url = urlMakeClass.getAiUrl()+"tag/"+requestTagDTO.getRequestId()+"/"+requestTagDTO.getImgName();
        // TODO Tag 요청한 반환값
        ResponseEntity<String> res = new RestTemplate().getForEntity(url, String.class);
        if (!Objects.equals(res.getBody(), "success")){
            return "fail";
        }
        return requestTagDTO.getRequestId();
    }

    @GetMapping("/api/{requestId}")
    public String apiRequestId(@PathVariable String requestId){
        String imgUrl = imageService.getImgUrl(requestId);
        return imgUrl;
    }
}
