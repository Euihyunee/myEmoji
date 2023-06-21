package com.emojiMaker.BackEnd.Controller;

import com.emojiMaker.BackEnd.Model.DTO.newDTO.*;

import com.emojiMaker.BackEnd.Model.UrlMakeClass;
import com.emojiMaker.BackEnd.Service.EmojiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emoji")
@CrossOrigin("*")
@Slf4j
public class EmojiController {

    @Autowired
    EmojiService emojiService;

    // TODO 도건 요청 오면
    @PostMapping("/response")
    public void completeRequest(@RequestBody List<ResponseEmojiDTO> responseEmojiDTO) {
        log.info("AI 이모티콘 요청에 대한 응답");
        ListResponseEmojiDTO listResponseEmojiDTO = new ListResponseEmojiDTO();
        listResponseEmojiDTO.setResponseEmojiDTOS(responseEmojiDTO);
        emojiService.responseExec(listResponseEmojiDTO);
    }
    // TODO Loading
    @PostMapping("/load")
    public void loading(@RequestBody RequestEmojiLoadDTO requestEmojiLoadDTO){
        log.info("AI 서버 이모티콘 요청 진행 중 : " + requestEmojiLoadDTO.getWait() + "%");
        emojiService.saveEmojiLoading(requestEmojiLoadDTO.getWait(), requestEmojiLoadDTO.getEmojiRequestId());
    }

    // TODO 사용자가 테그 선택 후 조회할 때 (완성, 미완성)
    // TODO 완성 시 url 전달
    @GetMapping("/status/{emojiRequestId}")
    public RequestClientEmojiDTO statusEmoji(@PathVariable String emojiRequestId) {
        log.info("프론트 서버에서 이모티콘 요청 ID로 이모티콘 데이터 요청");
        return emojiService.getExec(emojiRequestId);

    }
}
