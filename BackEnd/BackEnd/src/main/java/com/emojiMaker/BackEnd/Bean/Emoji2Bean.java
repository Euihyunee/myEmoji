package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Model.DAO.EmojiDAO;
import com.emojiMaker.BackEnd.Model.DAO.ImageDAO;
import com.emojiMaker.BackEnd.Model.DAO.RequestEmojiDAO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.EmojiDTO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.RequestClientEmojiDTO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Repository.EmojiDAORepository;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import com.emojiMaker.BackEnd.Repository.RequestEmojiDAORepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class Emoji2Bean {

    @Autowired
    ImageDAORepository imageDAORepository;
    @Autowired
    EmojiDAORepository emojiDAORepository;
    @Autowired
    RequestEmojiDAORepository requestEmojiDAORepository;

    public RequestClientEmojiDTO exec(String emojiRequestId){

        log.info("프론트 서버에 전달할 이모티콘 DTO 생성 : RequestClientEmojiDTO");
        RequestClientEmojiDTO requestClientEmojiDTO = new RequestClientEmojiDTO();
        log.info("이모티콘 요청 ID로 이모티콘 요청 엔티티 가져오기");
        RequestEmojiDAO requestEmojiDAO = requestEmojiDAORepository.findByEmojiRequestId(emojiRequestId);
        log.info("이모티콘 요청 엔티티로 이모티콘 DTO 정보 매핑");
        requestClientEmojiDTO.setStatus(requestEmojiDAO.getStatusType());
        log.info("상태(Status) 매핑 : " + requestEmojiDAO.getStatusType());
        requestClientEmojiDTO.setWait(requestEmojiDAO.getWait());
        log.info("로딩(Wait) 매핑 : " + requestEmojiDAO.getWait());
        requestClientEmojiDTO.setRequestId(requestEmojiDAO.getRequestId());
        log.info("요청 ID 매핑 : " + requestEmojiDAO.getRequestId());
        requestClientEmojiDTO.setEmojiRequestId(emojiRequestId);
        log.info("이모티콘 요청 ID 매핑 : " + emojiRequestId);
        requestClientEmojiDTO.setTagName(requestEmojiDAO.getTagName());
        log.info("태그명 매핑 : " + requestEmojiDAO.getTagName());
        if (requestEmojiDAO.getWait() == 100) {
            log.info("AI 서버로부터 이모티콘 요청 데이터가 들어왔을 때 이모티콘 DTO 정보 추가 매핑");
            requestEmojiDAO.setStatusType(StatusType.COMPLETEEMOJI);
            requestClientEmojiDTO.setStatus(StatusType.COMPLETEEMOJI);
            requestEmojiDAORepository.save(requestEmojiDAO);
            log.info("이모티콘 요청 ID로 이모티콘 엔티티(List<EmojiDAO>) 가져오기");
            List<EmojiDAO> emojiDAOList = emojiDAORepository.findAllByEmojiRequestId(emojiRequestId);
            List<EmojiDTO> emojiDTOS = new ArrayList<>();
            log.info("이모티콘 엔티티를 이모티콘 DTO에 매핑");
            for (EmojiDAO emojiDAO : emojiDAOList) {
                EmojiDTO emojiDTO = new EmojiDTO(emojiDAO.getEmojiTag(), emojiDAO.getEmojiUrl(), emojiDAO.getSetNum());
                emojiDTOS.add(emojiDTO);
            }
            requestClientEmojiDTO.setEmojiDTOS(emojiDTOS);
        }

        log.info("프론트 서버 요청에 대한 이모티콘 데이터 응답");
        return requestClientEmojiDTO;
    }
}
