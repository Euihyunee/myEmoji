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
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
    public String requestPhoto(String requestType, MultipartFile imgFile, int flag) throws IOException {
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

        // 1번 사진
        if(flag == 1){
            String resultPath1 = path + "\\tag1\\result1_1.png";
            String resultPath2 = path + "\\tag1\\result1_2.png";
            String resultPath3 = path + "\\tag1\\result1_3.png";
            String resultPath4 = path + "\\tag2\\result1_1.png";
            String resultPath5 = path + "\\tag2\\result1_2.png";
            String resultPath6 = path + "\\tag2\\result1_3.png";
            String resultPath7 = path + "\\tag3\\result1_1.png";
            String resultPath8 = path + "\\tag3\\result1_2.png";
            String resultPath9 = path + "\\tag3\\result1_3.png";

            File file1 = new File(resultPath1);
            File file2 = new File(resultPath2);
            File file3 = new File(resultPath3);
            File file4 = new File(resultPath4);
            File file5 = new File(resultPath5);
            File file6 = new File(resultPath6);
            File file7 = new File(resultPath7);
            File file8 = new File(resultPath8);
            File file9 = new File(resultPath9);

            File newFile1 = new File(path + "\\tag1\\" + id + "_1.png");
            File newFile2 = new File(path + "\\tag1\\" + id + "_2.png");
            File newFile3 = new File(path + "\\tag1\\" + id + "_3.png");
            File newFile4 = new File(path + "\\tag2\\" + id + "_1.png");
            File newFile5 = new File(path + "\\tag2\\" + id + "_2.png");
            File newFile6 = new File(path + "\\tag2\\" + id + "_3.png");
            File newFile7 = new File(path + "\\tag3\\" + id + "_1.png");
            File newFile8 = new File(path + "\\tag3\\" + id + "_2.png");
            File newFile9 = new File(path + "\\tag3\\" + id + "_3.png");

            Files.copy(file1.toPath(), newFile1.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(file2.toPath(), newFile2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(file3.toPath(), newFile3.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(file4.toPath(), newFile4.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(file5.toPath(), newFile5.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(file6.toPath(), newFile6.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(file7.toPath(), newFile7.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(file8.toPath(), newFile8.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(file9.toPath(), newFile9.toPath(), StandardCopyOption.REPLACE_EXISTING);

        }

        // 2번 사진
        if(flag == 2){
            String resultPath1 = path + "\\tag1\\result2_1.png";
            String resultPath2 = path + "\\tag1\\result2_2.png";
            String resultPath3 = path + "\\tag1\\result2_3.png";
            String resultPath4 = path + "\\tag2\\result2_1.png";
            String resultPath5 = path + "\\tag2\\result2_2.png";
            String resultPath6 = path + "\\tag2\\result2_3.png";
            String resultPath7 = path + "\\tag3\\result2_1.png";
            String resultPath8 = path + "\\tag3\\result2_2.png";
            String resultPath9 = path + "\\tag3\\result2_3.png";

            File file1 = new File(resultPath1);
            File file2 = new File(resultPath2);
            File file3 = new File(resultPath3);
            File file4 = new File(resultPath4);
            File file5 = new File(resultPath5);
            File file6 = new File(resultPath6);
            File file7 = new File(resultPath7);
            File file8 = new File(resultPath8);
            File file9 = new File(resultPath9);

            File newFile1 = new File(path + "\\tag1\\" + id + "_1.png");
            File newFile2 = new File(path + "\\tag1\\" + id + "_2.png");
            File newFile3 = new File(path + "\\tag1\\" + id + "_3.png");
            File newFile4 = new File(path + "\\tag2\\" + id + "_1.png");
            File newFile5 = new File(path + "\\tag2\\" + id + "_2.png");
            File newFile6 = new File(path + "\\tag2\\" + id + "_3.png");
            File newFile7 = new File(path + "\\tag3\\" + id + "_1.png");
            File newFile8 = new File(path + "\\tag3\\" + id + "_2.png");
            File newFile9 = new File(path + "\\tag3\\" + id + "_3.png");

            Files.copy(file1.toPath(), newFile1.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(file2.toPath(), newFile2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(file3.toPath(), newFile3.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(file4.toPath(), newFile4.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(file5.toPath(), newFile5.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(file6.toPath(), newFile6.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(file7.toPath(), newFile7.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(file8.toPath(), newFile8.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(file9.toPath(), newFile9.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }




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
