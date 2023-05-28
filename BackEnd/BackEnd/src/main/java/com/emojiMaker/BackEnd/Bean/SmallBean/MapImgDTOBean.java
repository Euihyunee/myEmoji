package com.emojiMaker.BackEnd.Bean.SmallBean;

import com.emojiMaker.BackEnd.Model.DTO.Image.ImageDTO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapImgDTOBean {

    @Autowired
    GetImgUrlBean getImgUrlBean;
    @Autowired
    GetRequestIdBean getRequestIdBean;
    @Autowired
    GetStatusBean getStatusBean;

    public void exec(String imgName){
        String requestId = getRequestIdBean.exec();
        String imgUrl = getImgUrlBean.exec(imgName);
        StatusType statusType = getStatusBean.exec();

        ImageDTO imageDTO = new ImageDTO(requestId, imgUrl, statusType);
    }
}
