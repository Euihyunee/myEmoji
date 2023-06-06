package com.emojiMaker.BackEnd.Controller;

import com.emojiMaker.BackEnd.Model.DTO.newDTO.ListResponseEmojiDTO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.RequestClientEmojiDTO;

import com.emojiMaker.BackEnd.Model.DTO.newDTO.ResponseEmojiDTO;
import com.emojiMaker.BackEnd.Model.UrlMakeClass;
import com.emojiMaker.BackEnd.Service.EmojiService;
import com.emojiMaker.BackEnd.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emoji")
@CrossOrigin("*")
public class EmojiController {

    @Autowired
    EmojiService emojiService;
    @Autowired
    TagService tagService;

    // TODO 도건 요청 오면
    @PostMapping("/response")
    public void completeRequest(@RequestBody List<ResponseEmojiDTO> responseEmojiDTO) {
        ListResponseEmojiDTO listResponseEmojiDTO = new ListResponseEmojiDTO();
        listResponseEmojiDTO.setResponseEmojiDTOS(responseEmojiDTO);
        System.out.println(listResponseEmojiDTO);
        emojiService.responseExec(listResponseEmojiDTO);
    }

    // TODO 사용자가 테그 선택 후 조회할 때 (완성, 미완성)
    // TODO 완성 시 url 전달
    @GetMapping("/status/{requestId}")
    public RequestClientEmojiDTO statusEmoji(@PathVariable String requestId) {
        UrlMakeClass urlMakeClass = new UrlMakeClass();
        System.out.println(urlMakeClass.getAiUrl());
        return emojiService.getExec(requestId);
    }
}
