package com.emojiMaker.BackEnd.Controller;

import com.emojiMaker.BackEnd.Model.DTO.newDTO.*;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Model.UrlMakeClass;
import com.emojiMaker.BackEnd.Service.ImageService;
import com.emojiMaker.BackEnd.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/tag")
@CrossOrigin("*")
public class TagController {

    UrlMakeClass urlMakeClass = new UrlMakeClass();

    @Autowired
    TagService tagService;
    @Autowired
    ImageService imageService;


    // TODO request AI Tag to response
    // TODO input : {reqyestId, tagName, tagUrl}
    @PostMapping("/response")
    public void responseTag(@RequestBody List<ResponseTagDTO> responseTagDTOS){
        ListResponseTagDTO listResponseTagDTO = new ListResponseTagDTO();
        listResponseTagDTO.setResponseTagDTOS(responseTagDTOS);
        System.out.println(listResponseTagDTO);
        imageService.responseTag(listResponseTagDTO);
    }
    @GetMapping("/status/{requestId}")
    public RequestClientTagDTO getTag(@PathVariable String requestId) {
        RequestClientTagDTO requestClientTagDTO = tagService.exec3(requestId);
        System.out.println(requestClientTagDTO);
        return requestClientTagDTO;
    }

    // TODO client한테서 request_id, tag_name 들어옴
    @GetMapping("/select/{requestId}/{tagName}/{setNum}")
    public String selectTag(@PathVariable String requestId, @PathVariable String tagName,
                            @PathVariable int setNum){
        RequestUrlEmojiDTO requestUrlEmojiDTO = tagService.exec1(requestId, tagName, setNum);
        String url = urlMakeClass.getAiUrl()+"stable/"+requestId+"/"
                + requestUrlEmojiDTO.getImgName() +"/"+tagName;
        System.out.println(url);
        ResponseEntity<String> res = new RestTemplate().getForEntity(url, String.class);

        return res.getBody();
    }
    @GetMapping("/api/{requestId}/{tagName}")
    public RequestTagDTO apiRequest(@PathVariable String requestId, @PathVariable String tagName) {
        return new RequestTagDTO(requestId, tagName);
    }
}
