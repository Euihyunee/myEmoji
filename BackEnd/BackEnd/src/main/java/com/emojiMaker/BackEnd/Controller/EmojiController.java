package com.emojiMaker.BackEnd.Controller;

import com.emojiMaker.BackEnd.Model.DTO.newDTO.*;

import com.emojiMaker.BackEnd.Model.UrlMakeClass;
import com.emojiMaker.BackEnd.Service.EmojiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emoji")
@CrossOrigin("*")
public class EmojiController {

    @Autowired
    EmojiService emojiService;

    // TODO 도건 요청 오면
    @PostMapping("/response")
    public void completeRequest(@RequestBody List<ResponseEmojiDTO> responseEmojiDTO) {
        ListResponseEmojiDTO listResponseEmojiDTO = new ListResponseEmojiDTO();
        listResponseEmojiDTO.setResponseEmojiDTOS(responseEmojiDTO);
        System.out.println(listResponseEmojiDTO);
        emojiService.responseExec(listResponseEmojiDTO);
    }
    // TODO Loading
    @PostMapping("/load")
    public void loading(@RequestBody RequestEmojiLoadDTO requestEmojiLoadDTO){
        emojiService.saveEmojiLoading(requestEmojiLoadDTO.getWait(), requestEmojiLoadDTO.getEmojiRequestId());
    }

    // TODO 사용자가 테그 선택 후 조회할 때 (완성, 미완성)
    // TODO 완성 시 url 전달
    @GetMapping("/status/{emojiRequestId}")
    public RequestClientEmojiDTO statusEmoji(@PathVariable String emojiRequestId) {
        UrlMakeClass urlMakeClass = new UrlMakeClass();
        System.out.println(urlMakeClass.getAiUrl());
        return emojiService.getExec(emojiRequestId);
    }
}
