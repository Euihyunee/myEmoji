package com.emojiMaker.BackEnd.Service;

import com.emojiMaker.BackEnd.Bean.Image1Bean;
import com.emojiMaker.BackEnd.Bean.SmallBean.GetStatusBean;
import com.emojiMaker.BackEnd.Model.DTO.Image.ImageDTO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    Image1Bean image1Bean;
    @Autowired
    GetStatusBean getStatusBean;

    public String uploadImg(MultipartFile imgFile) throws IOException {
        return image1Bean.exec(imgFile);
    }
    public StatusType getStatus(String requestId){
        return getStatusBean.exec(requestId);
    }
}
