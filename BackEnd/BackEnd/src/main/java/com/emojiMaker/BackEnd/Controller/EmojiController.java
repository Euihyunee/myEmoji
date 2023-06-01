package com.emojiMaker.BackEnd.Controller;

import com.emojiMaker.BackEnd.Model.DTO.EmojiDTO.EmojiDTO;
import com.emojiMaker.BackEnd.Service.EmojiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emoji")
@CrossOrigin("*")
public class EmojiController {

    @Autowired
    EmojiService emojiService;

    // TODO 도건 요청 오면
    @PostMapping("/response")
    public void completeRequest(@RequestBody EmojiDTO emojiDTO) {
        emojiService.responseExec(emojiDTO);
    }


    // TODO 사용자가 테그 선택 후 조회할 때 (완성, 미완성)
    // TODO 완성 시 url 전달
    @GetMapping("/get/{requestId}")
    public String getEmoji(@PathVariable String requestId) {
        return emojiService.getExec(requestId);
    }
}
