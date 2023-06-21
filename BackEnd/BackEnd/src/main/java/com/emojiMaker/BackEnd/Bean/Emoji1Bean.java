package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Bean.SmallBean.MapEmojiDAOBean;
import com.emojiMaker.BackEnd.Bean.SmallBean.UpdateStatusBean;
import com.emojiMaker.BackEnd.Model.DAO.EmojiDAO;
import com.emojiMaker.BackEnd.Model.DAO.ImageDAO;
import com.emojiMaker.BackEnd.Model.DAO.RequestEmojiDAO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.ListResponseEmojiDTO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Repository.EmojiDAORepository;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import com.emojiMaker.BackEnd.Repository.RequestEmojiDAORepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class Emoji1Bean {

    @Autowired
    ImageDAORepository imageDAORepository;
    @Autowired
    UpdateStatusBean updateStatusBean;
    @Autowired
    MapEmojiDAOBean mapEmojiDAOBean;
    @Autowired
    EmojiDAORepository emojiDAORepository;
    @Autowired
    RequestEmojiDAORepository requestEmojiDAORepository;

    public void exec(ListResponseEmojiDTO listResponseEmojiDTO){
        //TODO Status 변경
        log.info("AI 이모티콘 응답 데이터에서 요청 ID 가져오기 ");
        String requestId = listResponseEmojiDTO.getResponseEmojiDTOS().get(0).getRequestId();
        log.info("요청 ID : " + requestId);
        log.info("AI 이모티콘 응답 데이터에서 Tag명 가져오기");
        String tagName = listResponseEmojiDTO.getResponseEmojiDTOS().get(0).getTagName();
        log.info("Tag명 : " + tagName);
        log.info("AI 이모티콘 응답 데이터에서 이모티콘 요청 ID 가져오기");
        String emojiRequestId = listResponseEmojiDTO.getResponseEmojiDTOS().get(0).getEmojiRequestId();
        log.info("이모티콘 요청 ID : " + emojiRequestId);

        log.info("요청 ID로 이미지 요청 엔티티(ImageDAO) 가져오기");
        ImageDAO imageDAO = imageDAORepository.findImageDAOByRequestId(requestId);
        imageDAO.setWait(100);
        log.info("이미지 요청 엔티티(ImageDAO)의 Status 변경 : WAITEMOJI -> COMPLETEEMOJI" );
        imageDAORepository.save(updateStatusBean.exec(imageDAO, 3));

        log.info("AI 이모티콘 응답 데이터에서 이모티콘 엔티티(EmojiDAO) 요소 추출");
        List<EmojiDAO> emojiDAOList = mapEmojiDAOBean.exec(
                emojiRequestId,requestId, tagName,
                listResponseEmojiDTO.getResponseEmojiDTOS());
        log.info("이모티콘 엔티티(EmojiDAO) 저장");
        emojiDAORepository.saveAll(emojiDAOList);
        log.info("이모티콘 요청 ID로 이모티콘 요청 엔티티(RequestEmojiDAO) 가져오기");
        RequestEmojiDAO requestEmojiDAO = requestEmojiDAORepository.findByEmojiRequestId(emojiRequestId);

        log.info("이모티콘 요청 엔티티(RequestEmojiDAO) 상태(Status) 변경");
        requestEmojiDAO.setStatusType(StatusType.COMPLETEEMOJI);
        log.info("이모티콘 요청 엔티티(RequestEmojiDAO) 로딩(Wait) 변경");
        requestEmojiDAO.setWait(100);
        log.info("이모티콘 요청 엔티티(RequestEmojiDAO) 저장");
        requestEmojiDAORepository.save(requestEmojiDAO);

    }

}
