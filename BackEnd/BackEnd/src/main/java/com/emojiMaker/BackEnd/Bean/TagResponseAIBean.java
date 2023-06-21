package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Bean.SmallBean.MapStyleDAOBean;
import com.emojiMaker.BackEnd.Bean.SmallBean.UpdateStatusBean;
import com.emojiMaker.BackEnd.Model.DAO.TagDAO;
import com.emojiMaker.BackEnd.Model.DAO.ImageDAO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.ListResponseTagDTO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.ResponseTagDTO;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import com.emojiMaker.BackEnd.Repository.TagDAORepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
@Slf4j
public class TagResponseAIBean {

    /* TODO 도건 Server에서 request_id, {img_url, tag_name}s 날아옴
        1. request_id로 status 조회
        2. status 수정 (enum 타입)
        3. DAO에 매핑
        4. DB에 DAO 저장
        # DAO : id, img_url, tag_name, request_id / tag 개수만큼 생김 */
    @Autowired
    MapStyleDAOBean mapStyleDAOBean;
    @Autowired
    ImageDAORepository imageDAORepository;
    @Autowired
    TagDAORepository tagDAORepository;
    @Autowired
    UpdateStatusBean updateStatusBean;

    public void exec(ListResponseTagDTO listResponseTagDTO) {

        // TODO requestId 뽑아냄
        log.info("AI 응답 데이터에서 요청 ID 가져오기");
        String requestId = listResponseTagDTO.getResponseTagDTOS().get(0).getRequestId();
        log.info("요청 ID : " + requestId);
        // TODO List형식으로 변경
        List<ResponseTagDTO> responseTagDTOS = listResponseTagDTO.getResponseTagDTOS();
        // TODO ImageDTO 뽑아내기(vaile 검사용)
        log.info("요청 ID로 DB에 저장된 엔티티(ImageDAO) 가져오기");
        ImageDAO imageDAO = imageDAORepository.findImageDAOByRequestId(requestId);

        log.info("가져온 엔티티가 비어있지 않은 경우 로직 실행");
        if (!StringUtils.isEmpty(imageDAO)){
            imageDAO.setWait(100);
            log.info("엔티티(ImageDAO) StatStatus 변경 WAITTAG -> COMPLETETAG");
            imageDAORepository.save( updateStatusBean.exec(imageDAO, 1));

            log.info("AI 응답 데이터의 Tag 데이터 엔티티(TagDAO) 매핑");
            List<TagDAO> tagDAOS = mapStyleDAOBean.exec(requestId, responseTagDTOS);
            log.info("Tag 데이터 엔티티(TagDAO) 저장");
            tagDAORepository.saveAll(tagDAOS);
        } else log.info("엔티티가 비어있는 경우");
    }

}
