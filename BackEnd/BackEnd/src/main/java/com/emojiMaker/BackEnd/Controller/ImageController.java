package com.emojiMaker.BackEnd.Controller;

import com.emojiMaker.BackEnd.Model.DTO.newDTO.RequestTagDTO;
import com.emojiMaker.BackEnd.Model.UrlMakeClass;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import com.emojiMaker.BackEnd.Service.ImageService;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ImageController {

    @Autowired
    ImageService imageService;
    @Autowired
    ImageDAORepository imageDAORepository;


// TODO img 들어옴
    @PostMapping("/upload")
    public String requestPhoto(@RequestPart MultipartFile imgFile,
                               @RequestParam String userId) throws IOException {
        // TODO 빠른 시간 요청 막기
        // TODO 파일명, requestId 필요함
        log.info("입력된 사용자 ID : " + userId + "\nFile명 : " + imgFile.getName());
        return imageService.uploadImg(imgFile, userId);
    }

    @GetMapping("/api/{requestId}")
    public String apiRequestId(@PathVariable String requestId){
        String imgUrl = imageService.getImgUrl(requestId);
        return imgUrl;
    }
}
