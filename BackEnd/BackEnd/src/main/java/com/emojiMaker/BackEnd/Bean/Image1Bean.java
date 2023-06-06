package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Bean.SmallBean.GetImgUrlBean;
import com.emojiMaker.BackEnd.Bean.SmallBean.GetRequestIdBean;
import com.emojiMaker.BackEnd.Bean.SmallBean.GetStatusBean;
import com.emojiMaker.BackEnd.Bean.SmallBean.SaveImageBean;
import com.emojiMaker.BackEnd.Model.DTO.Image.ImageDAO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.RequestTagDTO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class Image1Bean {

    @Autowired
    GetRequestIdBean getRequestIdBean;
    @Autowired
    SaveImageBean saveImageBean;
    @Autowired
    GetStatusBean getStatusBean;
    @Autowired
    GetImgUrlBean getImgUrlBean;
    @Autowired
    ImageDAORepository imageDAORepository;

    /* TODO Image 입력 받으면
            1. request_id 생성
            2. img_url, status 생성
            3. DTO 매핑
            4. DTO에 저장
            # DTO 정보 : request_id, img_url, img ,status */
    public RequestTagDTO exec(MultipartFile imgFile) throws IOException {

        // TODO requestId 만들기
        String requestId = getRequestIdBean.exec();
        // TODO 파일 저장하고 이름 가져오기
        String imgName = saveImageBean.exec(imgFile, requestId);
        // TODO ImgUrl 가져오기
        String imgUrl = getImgUrlBean.exec(imgName);
        // TODO StatusType 초기 설정
        StatusType statusType = getStatusBean.exec();
        // TODO ImageDAO 매핑
        ImageDAO imageDAO = new ImageDAO(requestId, imgUrl, imgName, statusType);
        // TODO ImageDAO 저장 처리
        imageDAORepository.save(imageDAO);
        // TODO Return 값 : requestId, imgName
        return new RequestTagDTO(requestId, imgName);
    }
}
