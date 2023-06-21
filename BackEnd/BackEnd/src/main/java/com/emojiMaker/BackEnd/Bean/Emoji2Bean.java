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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Emoji2Bean {

    @Autowired
    ImageDAORepository imageDAORepository;
    @Autowired
    EmojiDAORepository emojiDAORepository;
    @Autowired
    RequestEmojiDAORepository requestEmojiDAORepository;

    public RequestClientEmojiDTO exec(String emojiRequestId){

        RequestClientEmojiDTO requestClientEmojiDTO = new RequestClientEmojiDTO();
        RequestEmojiDAO requestEmojiDAO = requestEmojiDAORepository.findByEmojiRequestId(emojiRequestId);
        requestClientEmojiDTO.setStatus(requestEmojiDAO.getStatusType());
        requestClientEmojiDTO.setWait(requestEmojiDAO.getWait());
        requestClientEmojiDTO.setRequestId(requestEmojiDAO.getRequestId());
        requestClientEmojiDTO.setEmojiRequestId(emojiRequestId);
        requestClientEmojiDTO.setTagName(requestEmojiDAO.getTagName());
        if (requestEmojiDAO.getWait() == 100) {
            List<EmojiDAO> emojiDAOList = emojiDAORepository.findAllByRequestId(emojiRequestId);
            List<EmojiDTO> emojiDTOS = new ArrayList<>();
            for (EmojiDAO emojiDAO : emojiDAOList) {
                EmojiDTO emojiDTO = new EmojiDTO(emojiDAO.getEmojiTag(), emojiDAO.getEmojiUrl(), emojiDAO.getSetNum());
                emojiDTOS.add(emojiDTO);
            }
            requestClientEmojiDTO.setEmojiDTOS(emojiDTOS);
        }
//        ImageDAO imageDAO = imageDAORepository.findImageDAOByRequestId(emojiRequestId);
//        System.out.println(imageDAO);
//        if (imageDAO.getStatus() == StatusType.COMPLETEEMOJI) {
//            requestClientEmojiDTO.setRequestId(emojiRequestId);
//            requestClientEmojiDTO.setStatus(imageDAO.getStatus());
//            List<EmojiDAO> emojiDAOList = emojiDAORepository.findAllByRequestId(emojiRequestId);
//            requestClientEmojiDTO.setTagName(emojiDAOList.get(0).getTagName());
//            List<EmojiDTO> emojiDTOS = new ArrayList<>();
//            for (EmojiDAO emojiDAO : emojiDAOList) {
//                EmojiDTO emojiDTO = new EmojiDTO(emojiDAO.getEmojiTag(), emojiDAO.getEmojiUrl(), emojiDAO.getSetNum());
//                emojiDTOS.add(emojiDTO);
//            }
//            requestClientEmojiDTO.setEmojiDTOS(emojiDTOS);
//        }else if(imageDAO.getStatus() == null){
//            requestClientEmojiDTO.setStatus(StatusType.NOTVALUE);
//        }else{
//            requestClientEmojiDTO.setStatus(imageDAO.getStatus());
//        }
        return requestClientEmojiDTO;
    }
}
