package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Bean.SmallBean.*;
import com.emojiMaker.BackEnd.Model.DAO.ImageDAO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Model.UrlMakeClass;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Component
@Slf4j
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
    TagAuditingBean tagAuditingBean;

    UrlMakeClass urlMakeClass = new UrlMakeClass();

    /* TODO Image 입력 받으면
            1. request_id 생성
            2. img_url, status 생성
            3. DTO 매핑
            4. DTO에 저장
            # DTO 정보 : request_id, img_url, img ,status */

    public String exec(MultipartFile imgFile, String userId) throws IOException {
        if (tagAuditingBean.exec(userId)) {
            log.info("사용자 요청이 정상요청인지 확인");
            // TODO requestId 만들기
            log.info("요청 ID 만들기");
            String requestId = getRequestIdBean.exec();
            log.info("요청 ID : " + requestId);
            // TODO 파일 저장하고 이름 가져오기
            log.info("파일 저장하고 이름 가져오기");
            String imgName = saveImageBean.exec(imgFile, requestId);
            log.info("파일 이름 : " +imgName);
            // TODO ImgUrl 가져오기
            log.info("로컬에 저장된 이미지 URL 생성");
            String imgUrl = getImgUrlBean.exec(imgName);
            log.info("로컬 이미지 URL : " + imgUrl);
            // TODO StatusType 초기 설정
            log.info("StatusType 초기 설정(Tag 요청 대기)");
            StatusType statusType = getStatusBean.exec();
            log.info("statusType 초기 설정(Tag 요청 대기) : " + statusType);
            // TODO ImageDAO 매핑
            ImageDAO imageDAO = new ImageDAO(requestId, userId, imgUrl, imgName, statusType);
            log.info("요청 이미지 데이터(ImageDAO) 엔티티로 매핑");
            // TODO ImageDAO 저장 처리
            imageDAORepository.save(imageDAO);
            log.info("DB에 ImageDAO 저장 완료");

            // TODO Tag 요청 URL : Get방식, /{requestId}/{imgName}
            log.info("AI 서버에 Tag 데이터 요청할 URL 제작");
            String url = urlMakeClass.getAiUrl()+"tag/"+requestId+"/"+imgName;
            log.info("AI 서버 Tag 데이터 요청 URL : " + url);
            // TODO Tag 요청한 반환값
            log.info("AI 서버에 URL Tag 데이터 요청");
            ResponseEntity<String> res = new RestTemplate().getForEntity(url, String.class);
            log.info("AI 서버 Tag 데이터 응답 : " + res.getBody());
            if (!Objects.equals(res.getBody(), "success")){
                log.info("AI 서버 요청 실패");
                return "fail";
            }
            log.info("프론트에 전달할 데이터 :" + requestId);
            return requestId;
        }
        log.info("사용자의 잦은 빠른 요청으로 인한 요청 막기");
        return "timeError";
    }
}
