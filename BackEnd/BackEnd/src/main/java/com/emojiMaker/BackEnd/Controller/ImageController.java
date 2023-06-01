package com.emojiMaker.BackEnd.Controller;

import com.emojiMaker.BackEnd.Model.DTO.Image.ImageDTO;

import com.emojiMaker.BackEnd.Model.DTO.Style.StyleDTO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Service.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/image")
@CrossOrigin("*")
public class ImageController {

    @Autowired
    ImageService imageService;


// TODO img 들어옴
    @PostMapping("/upload")
    public String requestPhoto(@RequestPart MultipartFile imgFile) throws IOException {
        String requestId = imageService.uploadImg(imgFile);
        String url = "http://localhost:8080/image/api/"+ requestId;
        ResponseEntity<String> res = new RestTemplate().getForEntity(url, String.class);

        return res.getBody();
    }

    @GetMapping("/api/{requestId}")
    public String apiRequestId(@PathVariable String requestId){
        return requestId;
    }


    // TODO status 수정(도건Server에서 요청 들어옴)
    // TODO input : reqyestId, {img_url, tag_name}s
    @PostMapping("/postMethod")
    public void completeRequest(@RequestBody String requestId, List<StyleDTO> styleDTOList){


    }

    // TODO 결과 조회
    @GetMapping("/status/{requestId}")
    public StatusType getStatus(@PathVariable String requestId){
        return imageService.getStatus(requestId);
    }
}
