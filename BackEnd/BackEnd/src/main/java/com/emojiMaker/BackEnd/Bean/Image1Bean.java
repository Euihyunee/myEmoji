package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Bean.SmallBean.*;
import com.emojiMaker.BackEnd.Model.DAO.ImageDAO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.RequestTagDTO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Model.UrlMakeClass;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

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
    @Autowired
    AuditingBean auditingBean;

    UrlMakeClass urlMakeClass = new UrlMakeClass();

    /* TODO Image 입력 받으면
            1. request_id 생성
            2. img_url, status 생성
            3. DTO 매핑
            4. DTO에 저장
            # DTO 정보 : request_id, img_url, img ,status */
    public String exec(MultipartFile imgFile, String userId) throws IOException {

        if (auditingBean.exec(userId)) {
            // TODO requestId 만들기
            String requestId = getRequestIdBean.exec();
            // TODO 파일 저장하고 이름 가져오기
            String imgName = saveImageBean.exec(imgFile, requestId);
            // TODO ImgUrl 가져오기
            String imgUrl = getImgUrlBean.exec(imgName);
            // TODO StatusType 초기 설정
            StatusType statusType = getStatusBean.exec();
            // TODO ImageDAO 매핑
            ImageDAO imageDAO = new ImageDAO(requestId, userId, imgUrl, imgName, statusType);
            // TODO ImageDAO 저장 처리
            imageDAORepository.save(imageDAO);

            // TODO Tag 요청 URL : Get방식, /{requestId}/{imgName}
            String url = urlMakeClass.getAiUrl()+"tag/"+requestId+"/"+imgName;
            // TODO Tag 요청한 반환값
            ResponseEntity<String> res = new RestTemplate().getForEntity(url, String.class);
            if (!Objects.equals(res.getBody(), "success")){
                return "fail";
            }
            return requestId;
        }
        return "timeError";
    }
}
