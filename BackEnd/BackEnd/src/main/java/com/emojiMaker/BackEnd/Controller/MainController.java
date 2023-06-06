package com.emojiMaker.BackEnd.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class MainController {
//    Map<String , RequestUserInputDTO> map = new HashMap<String, RequestUserInputDTO>();
//    @Autowired
//    GerRequestTypeBean gerRequestTypeBean;
//
    @GetMapping("/")
    public String  main(){
        return "나만의 이모티콘 : myEmoji";
    }
//
//    @GetMapping("/data")
//    public String data(){
//        return map.toString();
//    }
//    @GetMapping("/data/img/{path}")
//    public void imgData(@PathVariable String path){
//
//    }
//
//
//    @PostMapping("/demo/request/photo")
//    public String requestPhoto(String requestType, MultipartFile imgFile, int flag) throws IOException {
//        // 아이디 생성
//        String id = UUID.randomUUID().toString();
//
//        // 이미지 저장 처리
//        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\input";
//        String imgName = "input_" + id + "_" + imgFile.getOriginalFilename();
//
//        File save = new File(projectPath, imgName);
//        imgFile.transferTo(save);
//
//        // string -> enum 변환
//        RequestType enumType = gerRequestTypeBean.exec(requestType);
//
//        // mapping
//        RequestUserInputDTO requestUserInputDTO = new RequestUserInputDTO();
//        requestUserInputDTO.setRequestId(id);
//        requestUserInputDTO.setImgUrl("/img/input/" + imgName);
//        requestUserInputDTO.setRequestType(enumType);
//
//        // save
//        map.put(id, requestUserInputDTO);
//
//
//        // 데모 모킹 (이미 있는 이미지 이름 변경)
//        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\resultTag";
//
//        // 1번 사진
//        if(flag == 1){
//            String resultPath1 = path + "\\tag1\\result1_1.png";
//            String resultPath2 = path + "\\tag1\\result1_2.png";
//            String resultPath3 = path + "\\tag1\\result1_3.png";
//            String resultPath4 = path + "\\tag2\\result1_1.png";
//            String resultPath5 = path + "\\tag2\\result1_2.png";
//            String resultPath6 = path + "\\tag2\\result1_3.png";
//            String resultPath7 = path + "\\tag3\\result1_1.png";
//            String resultPath8 = path + "\\tag3\\result1_2.png";
//            String resultPath9 = path + "\\tag3\\result1_3.png";
//
//            File file1 = new File(resultPath1);
//            File file2 = new File(resultPath2);
//            File file3 = new File(resultPath3);
//            File file4 = new File(resultPath4);
//            File file5 = new File(resultPath5);
//            File file6 = new File(resultPath6);
//            File file7 = new File(resultPath7);
//            File file8 = new File(resultPath8);
//            File file9 = new File(resultPath9);
//
//            File newFile1 = new File(path + "\\tag1\\" + id + "_1.png");
//            File newFile2 = new File(path + "\\tag1\\" + id + "_2.png");
//            File newFile3 = new File(path + "\\tag1\\" + id + "_3.png");
//            File newFile4 = new File(path + "\\tag2\\" + id + "_1.png");
//            File newFile5 = new File(path + "\\tag2\\" + id + "_2.png");
//            File newFile6 = new File(path + "\\tag2\\" + id + "_3.png");
//            File newFile7 = new File(path + "\\tag3\\" + id + "_1.png");
//            File newFile8 = new File(path + "\\tag3\\" + id + "_2.png");
//            File newFile9 = new File(path + "\\tag3\\" + id + "_3.png");
//
//            Files.copy(file1.toPath(), newFile1.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file2.toPath(), newFile2.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file3.toPath(), newFile3.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file4.toPath(), newFile4.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file5.toPath(), newFile5.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file6.toPath(), newFile6.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file7.toPath(), newFile7.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file8.toPath(), newFile8.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file9.toPath(), newFile9.toPath(), StandardCopyOption.REPLACE_EXISTING);
//
//        }
//
//        // 2번 사진
//        if(flag == 2){
//            String resultPath1 = path + "\\tag1\\result2_1.png";
//            String resultPath2 = path + "\\tag1\\result2_2.png";
//            String resultPath3 = path + "\\tag1\\result2_3.png";
//            String resultPath4 = path + "\\tag2\\result2_1.png";
//            String resultPath5 = path + "\\tag2\\result2_2.png";
//            String resultPath6 = path + "\\tag2\\result2_3.png";
//            String resultPath7 = path + "\\tag3\\result2_1.png";
//            String resultPath8 = path + "\\tag3\\result2_2.png";
//            String resultPath9 = path + "\\tag3\\result2_3.png";
//
//            File file1 = new File(resultPath1);
//            File file2 = new File(resultPath2);
//            File file3 = new File(resultPath3);
//            File file4 = new File(resultPath4);
//            File file5 = new File(resultPath5);
//            File file6 = new File(resultPath6);
//            File file7 = new File(resultPath7);
//            File file8 = new File(resultPath8);
//            File file9 = new File(resultPath9);
//
//            File newFile1 = new File(path + "\\tag1\\" + id + "_1.png");
//            File newFile2 = new File(path + "\\tag1\\" + id + "_2.png");
//            File newFile3 = new File(path + "\\tag1\\" + id + "_3.png");
//            File newFile4 = new File(path + "\\tag2\\" + id + "_1.png");
//            File newFile5 = new File(path + "\\tag2\\" + id + "_2.png");
//            File newFile6 = new File(path + "\\tag2\\" + id + "_3.png");
//            File newFile7 = new File(path + "\\tag3\\" + id + "_1.png");
//            File newFile8 = new File(path + "\\tag3\\" + id + "_2.png");
//            File newFile9 = new File(path + "\\tag3\\" + id + "_3.png");
//
//            Files.copy(file1.toPath(), newFile1.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file2.toPath(), newFile2.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file3.toPath(), newFile3.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file4.toPath(), newFile4.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file5.toPath(), newFile5.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file6.toPath(), newFile6.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file7.toPath(), newFile7.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file8.toPath(), newFile8.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file9.toPath(), newFile9.toPath(), StandardCopyOption.REPLACE_EXISTING);
//        }
//
//
//
//
//        return id;
//    }
//
//    @GetMapping("/demo/tag")
//    public List<ResponseTagImageDTO> getDemoTag(@ModelAttribute RequestDemoDTO requestDemoDTO){
//        String id = requestDemoDTO.getRequestId();
//
//
//        // 결과물 리턴
//        List<ResponseTagImageDTO> responseTagImageDTOs = new ArrayList<ResponseTagImageDTO>();
//
//        ResponseTagImageDTO responseTagImageDTO1 = new ResponseTagImageDTO("태그이름1", "/img/resultTag/tag1/" + id + "_1.png");
//        ResponseTagImageDTO responseTagImageDTO2 = new ResponseTagImageDTO("태그이름1", "/img/resultTag/tag1/" + id + "_2.png");
//        ResponseTagImageDTO responseTagImageDTO3 = new ResponseTagImageDTO("태그이름1", "/img/resultTag/tag1/" + id + "_3.png");
//        ResponseTagImageDTO responseTagImageDTO4 = new ResponseTagImageDTO("태그이름2", "/img/resultTag/tag2/" + id + "_1.png");
//        ResponseTagImageDTO responseTagImageDTO5 = new ResponseTagImageDTO("태그이름2", "/img/resultTag/tag2/" + id + "_2.png");
//        ResponseTagImageDTO responseTagImageDTO6 = new ResponseTagImageDTO("태그이름2", "/img/resultTag/tag2/" + id + "_3.png");
//        ResponseTagImageDTO responseTagImageDTO7 = new ResponseTagImageDTO("태그이름3", "/img/resultTag/tag3/" + id + "_1.png");
//        ResponseTagImageDTO responseTagImageDTO8 = new ResponseTagImageDTO("태그이름3", "/img/resultTag/tag3/" + id + "_2.png");
//        ResponseTagImageDTO responseTagImageDTO9 = new ResponseTagImageDTO("태그이름3",  "/img/resultTag/tag3/" + id + "_3.png");
//
//        responseTagImageDTOs.add(responseTagImageDTO1);
//        responseTagImageDTOs.add(responseTagImageDTO2);
//        responseTagImageDTOs.add(responseTagImageDTO3);
//        responseTagImageDTOs.add(responseTagImageDTO4);
//        responseTagImageDTOs.add(responseTagImageDTO5);
//        responseTagImageDTOs.add(responseTagImageDTO6);
//        responseTagImageDTOs.add(responseTagImageDTO7);
//        responseTagImageDTOs.add(responseTagImageDTO8);
//        responseTagImageDTOs.add(responseTagImageDTO9);
//
//
//
//        return responseTagImageDTOs;
//    }
//
//    @GetMapping("/demo/emoji/request")
//    public String requestDemoEmoji(@ModelAttribute RequestDemoEmojiDTO requestDemoEmojiDTO) throws IOException {
//        //
//        String id =requestDemoEmojiDTO.getRequestId();
//        String tagName = requestDemoEmojiDTO.getTagName();
//        List<String> imgUrl = new ArrayList<String>();
//
//        // mapping
//        ResponseEmojiResultDTO responseEmojiResultDTO = new ResponseEmojiResultDTO();
//
//
//        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\resultEmoji";
//
//
//        if (requestDemoEmojiDTO.getTagName().equals("태그이름1")) {
//            // tag1 복사
//            String resultPath1 = path + "\\tag1_1_1.png";
//            String resultPath2 = path + "\\tag1_1_2.png";
//            String resultPath3 = path + "\\tag1_1_3.png";
//            String resultPath4 = path + "\\tag1_1_4.png";
//            String resultPath5 = path + "\\tag1_1_5.png";
//
//            String resultPath6 = path + "\\tag1_2_1.png";
//            String resultPath7 = path + "\\tag1_2_2.png";
//            String resultPath8 = path + "\\tag1_2_3.png";
//            String resultPath9 = path + "\\tag1_2_4.png";
//            String resultPath10 = path + "\\tag1_2_5.png";
//
//            String resultPath11 = path + "\\tag1_3_1.png";
//            String resultPath12 = path + "\\tag1_3_2.png";
//            String resultPath13 = path + "\\tag1_3_3.png";
//            String resultPath14 = path + "\\tag1_3_4.png";
//            String resultPath15 = path + "\\tag1_3_5.png";
//
//
//            File file1 = new File(resultPath1);
//            File file2 = new File(resultPath2);
//            File file3 = new File(resultPath3);
//            File file4 = new File(resultPath4);
//            File file5 = new File(resultPath5);
//            File file6 = new File(resultPath6);
//            File file7 = new File(resultPath7);
//            File file8 = new File(resultPath8);
//            File file9 = new File(resultPath9);
//            File file10 = new File(resultPath10);
//            File file11 = new File(resultPath11);
//            File file12 = new File(resultPath12);
//            File file13 = new File(resultPath13);
//            File file14 = new File(resultPath14);
//            File file15 = new File(resultPath15);
//
//            File newFile1 = new File(path + "\\tag_" + id + "_1_1_1.png" );
//            File newFile2 = new File(path + "\\tag_" + id + "_1_1_2.png" );
//            File newFile3 = new File(path + "\\tag_" + id + "_1_1_3.png" );
//            File newFile4 = new File(path + "\\tag_" + id + "_1_1_4.png" );
//            File newFile5 = new File(path + "\\tag_" + id + "_1_1_5.png" );
//            File newFile6 = new File(path + "\\tag_" + id + "_1_2_1.png" );
//            File newFile7 = new File(path + "\\tag_" + id + "_1_2_2.png" );
//            File newFile8 = new File(path + "\\tag_" + id + "_1_2_3.png" );
//            File newFile9 = new File(path + "\\tag_" + id + "_1_2_4.png" );
//            File newFile10 = new File(path + "\\tag_" + id + "_1_2_5.png" );
//            File newFile11 = new File(path + "\\tag_" + id + "_1_3_1.png" );
//            File newFile12 = new File(path + "\\tag_" + id + "_1_3_2.png" );
//            File newFile13 = new File(path + "\\tag_" + id + "_1_3_3.png" );
//            File newFile14 = new File(path + "\\tag_" + id + "_1_3_4.png" );
//            File newFile15 = new File(path + "\\tag_" + id + "_1_3_5.png" );
//
//            Files.copy(file1.toPath(), newFile1.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file2.toPath(), newFile2.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file3.toPath(), newFile3.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file4.toPath(), newFile4.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file5.toPath(), newFile5.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file6.toPath(), newFile6.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file7.toPath(), newFile7.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file8.toPath(), newFile8.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file9.toPath(), newFile9.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file10.toPath(), newFile10.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file11.toPath(), newFile11.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file12.toPath(), newFile12.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file13.toPath(), newFile13.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file14.toPath(), newFile14.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file15.toPath(), newFile15.toPath(), StandardCopyOption.REPLACE_EXISTING);
//
//        }
//        if (requestDemoEmojiDTO.getTagName().equals("태그이름2")) {
//            // tag2 복사
//            String resultPath1 = path + "\\tag2_1_1.png";
//            String resultPath2 = path + "\\tag2_1_2.png";
//            String resultPath3 = path + "\\tag2_1_3.png";
//            String resultPath4 = path + "\\tag2_1_4.png";
//            String resultPath5 = path + "\\tag2_1_5.png";
//
//            String resultPath6 = path + "\\tag2_2_1.png";
//            String resultPath7 = path + "\\tag2_2_2.png";
//            String resultPath8 = path + "\\tag2_2_3.png";
//            String resultPath9 = path + "\\tag2_2_4.png";
//            String resultPath10 = path + "\\tag2_2_5.png";
//
//            String resultPath11 = path + "\\tag2_3_1.png";
//            String resultPath12 = path + "\\tag2_3_2.png";
//            String resultPath13 = path + "\\tag2_3_3.png";
//            String resultPath14 = path + "\\tag2_3_4.png";
//            String resultPath15 = path + "\\tag2_3_5.png";
//
//
//            File file1 = new File(resultPath1);
//            File file2 = new File(resultPath2);
//            File file3 = new File(resultPath3);
//            File file4 = new File(resultPath4);
//            File file5 = new File(resultPath5);
//            File file6 = new File(resultPath6);
//            File file7 = new File(resultPath7);
//            File file8 = new File(resultPath8);
//            File file9 = new File(resultPath9);
//            File file10 = new File(resultPath10);
//            File file11 = new File(resultPath11);
//            File file12 = new File(resultPath12);
//            File file13 = new File(resultPath13);
//            File file14 = new File(resultPath14);
//            File file15 = new File(resultPath15);
//
//            File newFile1 = new File(path + "\\tag_" + id + "_2_1_1.png" );
//            File newFile2 = new File(path + "\\tag_" + id + "_2_1_2.png" );
//            File newFile3 = new File(path + "\\tag_" + id + "_2_1_3.png" );
//            File newFile4 = new File(path + "\\tag_" + id + "_2_1_4.png" );
//            File newFile5 = new File(path + "\\tag_" + id + "_2_1_5.png" );
//            File newFile6 = new File(path + "\\tag_" + id + "_2_2_1.png" );
//            File newFile7 = new File(path + "\\tag_" + id + "_2_2_2.png" );
//            File newFile8 = new File(path + "\\tag_" + id + "_2_2_3.png" );
//            File newFile9 = new File(path + "\\tag_" + id + "_2_2_4.png" );
//            File newFile10 = new File(path + "\\tag_" + id + "_2_2_5.png" );
//            File newFile11 = new File(path + "\\tag_" + id + "_2_3_1.png" );
//            File newFile12 = new File(path + "\\tag_" + id + "_2_3_2.png" );
//            File newFile13 = new File(path + "\\tag_" + id + "_2_3_3.png" );
//            File newFile14 = new File(path + "\\tag_" + id + "_2_3_4.png" );
//            File newFile15 = new File(path + "\\tag_" + id + "_2_3_5.png" );
//
//            Files.copy(file1.toPath(), newFile1.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file2.toPath(), newFile2.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file3.toPath(), newFile3.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file4.toPath(), newFile4.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file5.toPath(), newFile5.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file6.toPath(), newFile6.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file7.toPath(), newFile7.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file8.toPath(), newFile8.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file9.toPath(), newFile9.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file10.toPath(), newFile10.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file11.toPath(), newFile11.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file12.toPath(), newFile12.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file13.toPath(), newFile13.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file14.toPath(), newFile14.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            Files.copy(file15.toPath(), newFile15.toPath(), StandardCopyOption.REPLACE_EXISTING);
//
//        }
//
//        return "요청 성공";
//    }
//    @GetMapping("/demo/emoji/data")
//    public ResponseEmojiResultDTO getDemoEmoji(@ModelAttribute RequestDemoEmojiDTO requestDemoEmojiDTO) {
//
//        String path = "/img/resultEmoji";
//        ResponseEmojiResultDTO responseEmojiResultDTO = new ResponseEmojiResultDTO();
//
//
//        if (requestDemoEmojiDTO.getTagName().equals("태그이름1")) {
//            String resultPath1 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_1_1_1.png";
//            String resultPath2 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_1_1_2.png";
//            String resultPath3 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_1_1_3.png";
//            String resultPath4 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_1_1_4.png";
//            String resultPath5 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_1_1_5.png";
//            String resultPath6 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_1_2_1.png";
//            String resultPath7 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_1_2_2.png";
//            String resultPath8 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_1_2_3.png";
//            String resultPath9 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_1_2_4.png";
//            String resultPath10 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_1_2_5.png";
//            String resultPath11 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_1_3_1.png";
//            String resultPath12 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_1_3_2.png";
//            String resultPath13 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_1_3_3.png";
//            String resultPath14 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_1_3_4.png";
//            String resultPath15 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_1_3_5.png";
//
//            ResponseEmojiDTO responseEmojiDTO1 = new ResponseEmojiDTO(resultPath1, "angry");
//            ResponseEmojiDTO responseEmojiDTO2 = new ResponseEmojiDTO(resultPath2, "heart");
//            ResponseEmojiDTO responseEmojiDTO3 = new ResponseEmojiDTO(resultPath3, "sad");
//            ResponseEmojiDTO responseEmojiDTO4 = new ResponseEmojiDTO(resultPath4, "smile");
//            ResponseEmojiDTO responseEmojiDTO5 = new ResponseEmojiDTO(resultPath5, "yawn");
//
//            ResponseEmojiDTO responseEmojiDTO6 = new ResponseEmojiDTO(resultPath6, "angry");
//            ResponseEmojiDTO responseEmojiDTO7 = new ResponseEmojiDTO(resultPath7, "heart");
//            ResponseEmojiDTO responseEmojiDTO8 = new ResponseEmojiDTO(resultPath8, "sad");
//            ResponseEmojiDTO responseEmojiDTO9 = new ResponseEmojiDTO(resultPath9, "smile");
//            ResponseEmojiDTO responseEmojiDTO10 = new ResponseEmojiDTO(resultPath10, "yawn");
//
//            ResponseEmojiDTO responseEmojiDTO11 = new ResponseEmojiDTO(resultPath11, "angry");
//            ResponseEmojiDTO responseEmojiDTO12 = new ResponseEmojiDTO(resultPath12, "heart");
//            ResponseEmojiDTO responseEmojiDTO13 = new ResponseEmojiDTO(resultPath13, "sad");
//            ResponseEmojiDTO responseEmojiDTO14 = new ResponseEmojiDTO(resultPath14, "smile");
//            ResponseEmojiDTO responseEmojiDTO15 = new ResponseEmojiDTO(resultPath15, "yawn");
//
//            List<ResponseEmojiDTO> emoji1 = new ArrayList<ResponseEmojiDTO>();
//            emoji1.add(responseEmojiDTO1);
//            emoji1.add(responseEmojiDTO2);
//            emoji1.add(responseEmojiDTO3);
//            emoji1.add(responseEmojiDTO4);
//            emoji1.add(responseEmojiDTO5);
//
//            List<ResponseEmojiDTO> emoji2 = new ArrayList<ResponseEmojiDTO>();
//            emoji2.add(responseEmojiDTO6);
//            emoji2.add(responseEmojiDTO7);
//            emoji2.add(responseEmojiDTO8);
//            emoji2.add(responseEmojiDTO9);
//            emoji2.add(responseEmojiDTO10);
//
//            List<ResponseEmojiDTO> emoji3 = new ArrayList<ResponseEmojiDTO>();
//            emoji3.add(responseEmojiDTO11);
//            emoji3.add(responseEmojiDTO12);
//            emoji3.add(responseEmojiDTO13);
//            emoji3.add(responseEmojiDTO14);
//            emoji3.add(responseEmojiDTO15);
//
//            responseEmojiResultDTO.setEmoji1(emoji1);
//            responseEmojiResultDTO.setEmoji2(emoji2);
//            responseEmojiResultDTO.setEmoji3(emoji3);
//
//        }
//        if (requestDemoEmojiDTO.getTagName().equals("태그이름2")) {
//            String resultPath1 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_2_1_1.png";
//            String resultPath2 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_2_1_2.png";
//            String resultPath3 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_2_1_3.png";
//            String resultPath4 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_2_1_4.png";
//            String resultPath5 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_2_1_5.png";
//            String resultPath6 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_2_2_1.png";
//            String resultPath7 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_2_2_2.png";
//            String resultPath8 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_2_2_3.png";
//            String resultPath9 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_2_2_4.png";
//            String resultPath10 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_2_2_5.png";
//            String resultPath11 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_2_3_1.png";
//            String resultPath12 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_2_3_2.png";
//            String resultPath13 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_2_3_3.png";
//            String resultPath14 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_2_3_4.png";
//            String resultPath15 = path + "/tag_" + requestDemoEmojiDTO.getRequestId() + "_2_3_5.png";
//
//            ResponseEmojiDTO responseEmojiDTO1 = new ResponseEmojiDTO(resultPath1, "angry");
//            ResponseEmojiDTO responseEmojiDTO2 = new ResponseEmojiDTO(resultPath2, "heart");
//            ResponseEmojiDTO responseEmojiDTO3 = new ResponseEmojiDTO(resultPath3, "sad");
//            ResponseEmojiDTO responseEmojiDTO4 = new ResponseEmojiDTO(resultPath4, "smile");
//            ResponseEmojiDTO responseEmojiDTO5 = new ResponseEmojiDTO(resultPath5, "yawn");
//
//            ResponseEmojiDTO responseEmojiDTO6 = new ResponseEmojiDTO(resultPath6, "angry");
//            ResponseEmojiDTO responseEmojiDTO7 = new ResponseEmojiDTO(resultPath7, "heart");
//            ResponseEmojiDTO responseEmojiDTO8 = new ResponseEmojiDTO(resultPath8, "sad");
//            ResponseEmojiDTO responseEmojiDTO9 = new ResponseEmojiDTO(resultPath9, "smile");
//            ResponseEmojiDTO responseEmojiDTO10 = new ResponseEmojiDTO(resultPath10, "yawn");
//
//            ResponseEmojiDTO responseEmojiDTO11 = new ResponseEmojiDTO(resultPath11, "angry");
//            ResponseEmojiDTO responseEmojiDTO12 = new ResponseEmojiDTO(resultPath12, "heart");
//            ResponseEmojiDTO responseEmojiDTO13 = new ResponseEmojiDTO(resultPath13, "sad");
//            ResponseEmojiDTO responseEmojiDTO14 = new ResponseEmojiDTO(resultPath14, "smile");
//            ResponseEmojiDTO responseEmojiDTO15 = new ResponseEmojiDTO(resultPath15, "yawn");
//
//            List<ResponseEmojiDTO> emoji1 = new ArrayList<ResponseEmojiDTO>();
//            emoji1.add(responseEmojiDTO1);
//            emoji1.add(responseEmojiDTO2);
//            emoji1.add(responseEmojiDTO3);
//            emoji1.add(responseEmojiDTO4);
//            emoji1.add(responseEmojiDTO5);
//
//            List<ResponseEmojiDTO> emoji2 = new ArrayList<ResponseEmojiDTO>();
//            emoji2.add(responseEmojiDTO6);
//            emoji2.add(responseEmojiDTO7);
//            emoji2.add(responseEmojiDTO8);
//            emoji2.add(responseEmojiDTO9);
//            emoji2.add(responseEmojiDTO10);
//
//            List<ResponseEmojiDTO> emoji3 = new ArrayList<ResponseEmojiDTO>();
//            emoji3.add(responseEmojiDTO11);
//            emoji3.add(responseEmojiDTO12);
//            emoji3.add(responseEmojiDTO13);
//            emoji3.add(responseEmojiDTO14);
//            emoji3.add(responseEmojiDTO15);
//
//            responseEmojiResultDTO.setEmoji1(emoji1);
//            responseEmojiResultDTO.setEmoji2(emoji2);
//            responseEmojiResultDTO.setEmoji3(emoji3);
//        }
//
//
//
//
//        return responseEmojiResultDTO;
//
//    }



}
