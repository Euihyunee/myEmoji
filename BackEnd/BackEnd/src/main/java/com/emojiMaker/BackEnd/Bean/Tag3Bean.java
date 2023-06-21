package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Bean.SmallBean.GetStatusBean;
import com.emojiMaker.BackEnd.Model.DAO.TagDAO;
import com.emojiMaker.BackEnd.Model.DAO.ImageDAO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.TagDTO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.RequestClientTagDTO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import com.emojiMaker.BackEnd.Repository.TagDAORepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class Tag3Bean {

    @Autowired
    ImageDAORepository imageDAORepository;
    @Autowired
    TagDAORepository tagDAORepository;
    @Autowired
    GetStatusBean getStatusBean;

    public RequestClientTagDTO exec(String requestId) {

        log.info("요청 ID로 ImageDAO 가져오기");
        ImageDAO imageDAO = imageDAORepository.findImageDAOByRequestId(requestId);
        StatusType statusType = imageDAO.getStatus();

        //TODO 아직 AI response 없을 때 status, wait 반환
        log.info("AI 서버에서 Tag 요청에 대한 응답이 없을 때");

        log.info("프론트 서버에 전달할 태그 DTO 생성");
        RequestClientTagDTO requestClientTagDTO = new RequestClientTagDTO();
        requestClientTagDTO.setStatus(statusType);
        log.info("현재 Status DTO에 매핑 : " + statusType);
        requestClientTagDTO.setWait(imageDAO.getWait());
        log.info("현재 진행도(Wait) DTO에 매핑 : " + imageDAO.getWait());
        requestClientTagDTO.setRequestId(requestId);
        log.info("요청ID DTO에 매핑 : " + requestId);

        // TODO wait 100일때 매핑
        if (imageDAO.getWait() == 100) {
            log.info("AI 서버에서 Tag 요청에 대한 응답 도착 완료");
            List<TagDTO> tagDTOS = new ArrayList<>();
            log.info("TagDAO 리스트 DTO에 매핑");
            List<TagDAO> tagDAOList = tagDAORepository.findAllByRequestId(requestId);
            for (TagDAO tagDAO : tagDAOList) {
                TagDTO tagDTO = new TagDTO(tagDAO.getTagName(),
                        tagDAO.getTagUrl(), tagDAO.getSetNum());
                tagDTOS.add(tagDTO);
            }
            requestClientTagDTO.setTagDTOS(tagDTOS);
            log.info("프론트 서버에 매핑된 DTO 전달");
            return requestClientTagDTO;
        }
        log.info("프론트 서버에 매핑된 DTO 전달");
        return requestClientTagDTO;
    }
}
