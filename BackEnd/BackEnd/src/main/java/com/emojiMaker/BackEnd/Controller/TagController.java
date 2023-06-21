package com.emojiMaker.BackEnd.Controller;

import com.emojiMaker.BackEnd.Model.DTO.newDTO.*;
import com.emojiMaker.BackEnd.Model.UrlMakeClass;
import com.emojiMaker.BackEnd.Service.ImageService;
import com.emojiMaker.BackEnd.Service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/tag")
@CrossOrigin("*")
@Slf4j
public class TagController {

    UrlMakeClass urlMakeClass = new UrlMakeClass();

    @Autowired
    TagService tagService;
    @Autowired
    ImageService imageService;


    // TODO request AI Tag to response
    // TODO input : {reqyestId, tagName, tagUrl}
    @PostMapping("/response")
    public void responseTag(@RequestBody List<ResponseTagDTO> responseTagDTOS) {
        log.info("AI Tag 요청 데이터에 대한 응답");
        ListResponseTagDTO listResponseTagDTO = new ListResponseTagDTO();
        listResponseTagDTO.setResponseTagDTOS(responseTagDTOS);
        imageService.responseTag(listResponseTagDTO);
    }

    // TODO Loading
    @PostMapping("/load")
    public void loading(@RequestBody RequestTagLoadDTO requestTagLoadDTO) {
        log.info("AI Tag 요청에 대한 로딩 데이터(Wait) : " + requestTagLoadDTO.getWait());
        tagService.saveTagLoading(requestTagLoadDTO.getWait(), requestTagLoadDTO.getRequestId());
    }

    @GetMapping("/status/{requestId}")
    public RequestClientTagDTO getTag(@PathVariable String requestId) {
        log.info("프론트 서버에서 요청ID로 태그 데이터 요청 :" + requestId);
        RequestClientTagDTO requestClientTagDTO = tagService.exec3(requestId);
        return requestClientTagDTO;
    }

    // TODO client한테서 request_id, tag_name 들어옴 return emojiRequestId
    @GetMapping("/select/{userId}/{requestId}/{tagName}/{setNum}")
    public String selectTag(@PathVariable String userId,
                            @PathVariable String requestId,
                            @PathVariable String tagName,
                            @PathVariable int setNum) {
        log.info("클라이언트가 Tag 선택 : AI 서버로 이모티콘 요청");
        RequestUrlEmojiDTO requestUrlEmojiDTO = tagService.exec1(userId, requestId, tagName, setNum);
        log.info("AI 서버로 이모티콘 요청 URL 제작");
        String url = urlMakeClass.getAiUrl() + "stable/" + requestId + "/"
                + requestUrlEmojiDTO.getEmojiRequestId() + "/"
                + requestUrlEmojiDTO.getImgName() + "/" + tagName;
        log.info("AI 서버로 이모티콘 요청 URL : " + url);

        log.info("AI 서버로 이모티콘 요청");
        ResponseEntity<String> res = new RestTemplate().getForEntity(url, String.class);
        log.info("AI 서버의 이모티콘 요청에 대한 응답 : " + res.getBody());
        if (!Objects.equals(res.getBody(), "success")) {
            log.info("AI 서버의 이모티콘 요청 실패");
            return "invalid request";
        }
        log.info("AI 서버의 이모티콘 요청 성공 시 이모티콘 요청 ID 반환 : " +requestUrlEmojiDTO.getEmojiRequestId());
        return requestUrlEmojiDTO.getEmojiRequestId();
    }

    @GetMapping("/api/{requestId}/{tagName}")
    public RequestTagDTO apiRequest(@PathVariable String requestId, @PathVariable String tagName) {
        return new RequestTagDTO(requestId, tagName);
    }
}
