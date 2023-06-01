package com.emojiMaker.BackEnd.Controller;

import com.emojiMaker.BackEnd.Model.DTO.Image.ImageDTO;

import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Service.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/img")
@CrossOrigin("*")
public class ImageController {

    @Autowired
    ImageService imageService;


// TODO img 들어옴
    @PostMapping("/upload")
    public String requestPhoto(MultipartFile imgFile) throws IOException {

        return null;
//        return imageService.uploadImg(imgFile);
    }


    // TODO status 수정(도건Server에서 요청 들어옴)
    // TODO input : reqyestId, {img_url, tag_name}s
    @PostMapping("/postMethod")
    public void completeRequest(@RequestBody String status){

    }

    // TODO 결과 조회
    @GetMapping("/status/{requestId}")
    public StatusType getStatus(@PathVariable String requestId){
        return imageService.getStatus(requestId);
    }
}
