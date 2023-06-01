package com.emojiMaker.BackEnd.Service;

import com.emojiMaker.BackEnd.Bean.Image1Bean;
import com.emojiMaker.BackEnd.Bean.Image2Bean;
import com.emojiMaker.BackEnd.Bean.SmallBean.GetStatusBean;
import com.emojiMaker.BackEnd.Model.DTO.Image.ImageDTO;
import com.emojiMaker.BackEnd.Model.DTO.Style.Style1DTO;
import com.emojiMaker.BackEnd.Model.DTO.Style.StyleDTO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    Image1Bean image1Bean;
    @Autowired
    GetStatusBean getStatusBean;
    @Autowired
    Image2Bean image2Bean;

    public String uploadImg(MultipartFile imgFile) throws IOException {
        return image1Bean.exec(imgFile);
    }
    public StatusType getStatus(String requestId){
        return getStatusBean.exec(requestId);
    }

    public void responseTagName(Style1DTO style1DTO) {
        image2Bean.exec(style1DTO);
    }
}
