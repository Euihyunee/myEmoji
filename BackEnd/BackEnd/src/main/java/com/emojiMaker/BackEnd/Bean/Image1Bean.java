package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Bean.SmallBean.GetImgUrlBean;
import com.emojiMaker.BackEnd.Bean.SmallBean.GetRequestIdBean;
import com.emojiMaker.BackEnd.Bean.SmallBean.GetStatusBean;
import com.emojiMaker.BackEnd.Bean.SmallBean.SaveImageBean;
import com.emojiMaker.BackEnd.Model.DTO.Image.ImageDTO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Repository.ImageDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class Image1Bean {

    /* TODO Image 입력 받으면
        1. request_id 생성
        2. img_url, status 생성
        3. DTO 매핑
        4. DTO에 저장
        # DTO 정보 : request_id, img_url, img ,status */
    @Autowired
    GetRequestIdBean getRequestIdBean;
    @Autowired
    SaveImageBean saveImageBean;
    @Autowired
    GetStatusBean getStatusBean;
    @Autowired
    GetImgUrlBean getImgUrlBean;
    @Autowired
    ImageDTORepository imageDTORepository;


    public ImageDTO exec(MultipartFile imgFile) throws IOException {

        // TODO 1번
        String requestId = getRequestIdBean.exec();
        String imgName = saveImageBean.exec(imgFile, requestId);
        // TODO 2번
        String imgUrl = getImgUrlBean.exec(imgName);
        StatusType statusType = getStatusBean.exec();

        ImageDTO imageDTO = new ImageDTO(requestId, imgUrl, statusType);
        // TODO Image 저장 처리
        imageDTORepository.save(imageDTO);
        return imageDTO;
    }
}
