package com.emojiMaker.BackEnd.Service;

import com.emojiMaker.BackEnd.Bean.Image1Bean;
import com.emojiMaker.BackEnd.Bean.SmallBean.GetImgUrlBean;
import com.emojiMaker.BackEnd.Bean.TagResponseAIBean;
import com.emojiMaker.BackEnd.Bean.SmallBean.GetStatusBean;
import com.emojiMaker.BackEnd.Model.DTO.Image.ImageDAO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.ListResponseTagDTO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.RequestTagDTO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
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
    @Autowired
    TagResponseAIBean tagResponseAIBean;
    @Autowired
    ImageDAORepository imageDAORepository;

    public RequestTagDTO uploadImg(MultipartFile imgFile) throws IOException {
        return image1Bean.exec(imgFile);
    }
    public StatusType getStatus(String requestId){
        return getStatusBean.exec(requestId);
    }

    public void responseTag(ListResponseTagDTO listResponseTagDTO) {
        tagResponseAIBean.exec(listResponseTagDTO);
    }
    public String getImgUrl(String requestId){
        ImageDAO imageDAO =  imageDAORepository.findImageDAOByRequestId(requestId);
        return imageDAO.getImgUrl();
    }
}
