package com.emojiMaker.BackEnd.Bean.SmallBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class SaveImageBean {
    public String exec(MultipartFile imgFile, String requestId) throws IOException {
        String projectPath = System.getProperty("user.dir") + "/img/";
        String imgName =requestId+"_"+imgFile.getOriginalFilename();
        File url = new File(projectPath + imgName);
        imgFile.transferTo(url);
        return imgName;
    }
}
