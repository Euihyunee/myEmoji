package com.emojiMaker.BackEnd.Controller;

import com.emojiMaker.BackEnd.Model.DTO.Style.RequestTagDTO;
import com.emojiMaker.BackEnd.Model.DTO.Style.StyleDTO;
import com.emojiMaker.BackEnd.Service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/style")
@CrossOrigin("*")
public class StyleController {

    @Autowired
    StyleService styleService;

    // TODO client한테서 request_id, tag_name 들어옴
    @GetMapping("/select/{requestId}/{tagName}")
    public RequestTagDTO selectTag(@PathVariable String requestId, @PathVariable String tagName){
        styleService.exec1(requestId, tagName);
        String url = "http://localhost:8080/style/api/"+requestId+"/"+tagName;
        System.out.println(url);
        ResponseEntity<RequestTagDTO> res = new RestTemplate().getForEntity(url, RequestTagDTO.class);

        return res.getBody();
    }


    @GetMapping("/api/{requestId}/{tagName}")
    public RequestTagDTO apiRequest(@PathVariable String requestId, @PathVariable String tagName) {
        return new RequestTagDTO(requestId, tagName);
    }

    // TODO 결과 조회
    @GetMapping("/tag/{requestId}")
    public StyleDTO getTag(@PathVariable String requestId) {
        return styleService.exec3(requestId);
    }
}
