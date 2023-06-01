package com.emojiMaker.BackEnd.Controller;

import com.emojiMaker.BackEnd.Model.DTO.Style.ResponseTagDTO;
import com.emojiMaker.BackEnd.Model.DTO.Style.StyleDTO;
import com.emojiMaker.BackEnd.Model.DTO.Style.TagDTO;
import com.emojiMaker.BackEnd.Service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/style")
@CrossOrigin("*")
public class StyleController {

    @Autowired
    StyleService styleService;

    // TODO client한테서 request_id, tag_name 들어옴
    @PostMapping("/select")
    public void selectTag(@RequestBody ResponseTagDTO responseTagDTO){
        System.out.println(responseTagDTO);
    }
    // TODO status 수정 부분(도건Server에서 요청 날림)

    // TODO 결과 조회
    @GetMapping("/tag/{requestId}")
    public StyleDTO getTag(@PathVariable String requestId) {
        return styleService.exec(requestId);
    }
}
