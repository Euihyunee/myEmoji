package com.emojiMaker.BackEnd.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/img")
@CrossOrigin("*")
@Controller
public class ImageController {

    // TODO img 들어옴
    @GetMapping("/request/{img}")
    public void imgData(@PathVariable String img){
        // TODO (uuid, img, status) DTO 매핑 후 저장
    }

    // TODO status 수정(도건Server에서 요청 들어옴)
    @PostMapping("/postMethod")
    public void completeRequest(@RequestBody String status){

    }

    // TODO 결과 조회
    @GetMapping("/status/{requestId}")
    public String getStatus(@PathVariable String requestId){

        return requestId;
    }
}
