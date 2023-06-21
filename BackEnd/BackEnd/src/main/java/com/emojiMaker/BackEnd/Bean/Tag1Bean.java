package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Bean.SmallBean.UpdateStatusBean;
import com.emojiMaker.BackEnd.Model.DAO.RequestEmojiDAO;
import com.emojiMaker.BackEnd.Model.DAO.TagDAO;
import com.emojiMaker.BackEnd.Model.DAO.ImageDAO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.RequestUrlEmojiDTO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import com.emojiMaker.BackEnd.Repository.RequestEmojiDAORepository;
import com.emojiMaker.BackEnd.Repository.TagDAORepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Tag1Bean {

    /* TODO Client 화풍 선택 request_id, tag_name이 들어옴
        도건 Server에 요청, status 수정
        request_id, tag_name 반환
        status 수정 */
    @Autowired
    TagDAORepository tagDAORepository;
    @Autowired
    ImageDAORepository imageDAORepository;
    @Autowired
    UpdateStatusBean updateStatusBean;
    @Autowired
    RequestEmojiDAORepository requestEmojiDAORepository;

    public RequestUrlEmojiDTO exec(String userId, String requestId, String tagName, int setNum){

        log.info("선택한 TagDAO 가져오기");
        TagDAO tagDAO = tagDAORepository.findByRequestIdAndTagNameAndSetNum(
                requestId, tagName, setNum);
        log.info("AI 서버로 요청하기 위한 데이터(RequestUrlEmojiDTO) 생성");
        RequestUrlEmojiDTO requestUrlEmojiDTO = new RequestUrlEmojiDTO();
        if (tagDAO != null) {
            log.info("이미지 요청 ID(RequestId)로 ImageDAO 가져오기");
            ImageDAO imageDAO = imageDAORepository.findImageDAOByRequestId(requestId);
            log.info("ImageDAO의 Status 변경 : COMPLETETAG -> WAITEMOJI");
            imageDAORepository.save(updateStatusBean.exec(imageDAO, 2));
            log.info("이모티콘 요청 엔티티(RequestEmojiDAO) 제작");
            RequestEmojiDAO requestEmojiDAO = new RequestEmojiDAO(requestId, userId,
                    StatusType.WAITEMOJI, tagName, setNum);
            log.info("이모티콘 요청 엔티티(RequestEmojiDAO) 저장");
            requestEmojiDAORepository.save(requestEmojiDAO);
            log.info("AI 요청 데이터(RequestUrlEmojiDTO)에 이모티곤 요청 ID 매핑");
            requestUrlEmojiDTO.setEmojiRequestId(requestEmojiDAO.getEmojiRequestId());
            log.info("이모티콘 요청 ID :" + requestEmojiDAO.getEmojiRequestId());
        }
        ImageDAO imageDAO = imageDAORepository.findImageDAOByRequestId(requestId);

        log.info("AI 요청 데이터(RequestUrlEmojiDTO)에 원본 이미지 이름 매핑");
        requestUrlEmojiDTO.setImgName(imageDAO.getImgName());
        log.info("원본 이미지 이름 : " + imageDAO.getImgName());
        requestUrlEmojiDTO.setSetNum(tagDAO.getSetNum());
        return requestUrlEmojiDTO;
    }
}
