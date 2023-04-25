package com.emojiMaker.BackEnd.Controller;

import com.emojiMaker.BackEnd.Bean.GerRequestTypeBean;
import com.emojiMaker.BackEnd.Model.DTO.Request.RequestDemoDTO;
import com.emojiMaker.BackEnd.Model.DTO.Request.RequestDemoEmojiDTO;
import com.emojiMaker.BackEnd.Model.DTO.Request.RequestUserInputDTO;
import com.emojiMaker.BackEnd.Model.DTO.Response.ResponseTagImageDTO;
import com.emojiMaker.BackEnd.Model.Enum.RequestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class MainController {
    Map<String , RequestUserInputDTO> map = new HashMap<String, RequestUserInputDTO>();
    @Autowired
    GerRequestTypeBean gerRequestTypeBean;

    @GetMapping("/")
    public String  main(){
        return "나만의 이모티콘 : myEmoji";
    }

    @GetMapping("/data")
    public String data(){
        return map.toString();
    }
    @GetMapping("/data/img/{path}")
    public void imgData(@PathVariable String path){

    }


    @PostMapping("/demo/request/photo")
    public String requestPhoto(String requestType, MultipartFile imgFile) throws IOException {
        // 아이디 생성
        String id = UUID.randomUUID().toString();

        // 이미지 저장 처리
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\input";
        String imgName = "input_" + id + "_" + imgFile.getOriginalFilename();

        File save = new File(projectPath, imgName);
        imgFile.transferTo(save);

        // string -> enum 변환
        RequestType enumType = gerRequestTypeBean.exec(requestType);

        // mapping
        RequestUserInputDTO requestUserInputDTO = new RequestUserInputDTO();
        requestUserInputDTO.setRequestId(id);
        requestUserInputDTO.setImgUrl("/img/input/" + imgName);
        requestUserInputDTO.setRequestType(enumType);

        // save
        map.put(id, requestUserInputDTO);


        // 데모 모킹 (이미 있는 이미지 이름 변경)
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\resultTag";
        File file = new File(path);






        return id;
    }

    @GetMapping("/demo/tag")
    public ResponseTagImageDTO getDemoTagImage(@RequestParam RequestDemoDTO requestDemoDTO){
        String id = requestDemoDTO.getRequestId();

        // 아이디로 결과물 있는지 조회

        // 결과물 리턴


        map.get(id);
        ResponseTagImageDTO responseTagImageDTO = new ResponseTagImageDTO();
        return responseTagImageDTO;
    }

    @GetMapping("/demo/emoji")
    public void getDemoEmojiImage(@RequestParam RequestDemoEmojiDTO requestDemoEmojiDTO){

    }




}
