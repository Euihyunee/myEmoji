package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Model.DAO.EmojiDAO;
import com.emojiMaker.BackEnd.Model.DTO.Image.ImageDAO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.EmojiDTO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.RequestClientEmojiDTO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Repository.EmojiDAORepository;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
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

    public RequestClientEmojiDTO exec(String requestId){
        ImageDAO imageDAO = imageDAORepository.findImageDAOByRequestId(requestId);
        System.out.println(imageDAO);
        RequestClientEmojiDTO requestClientEmojiDTO = new RequestClientEmojiDTO();

        if (imageDAO.getStatus() == StatusType.COMPLETEEMOJI) {
            requestClientEmojiDTO.setRequestId(requestId);
            requestClientEmojiDTO.setStatus(imageDAO.getStatus());
            List<EmojiDAO> emojiDAOList = emojiDAORepository.findAllByRequestId(requestId);
            requestClientEmojiDTO.setTagName(emojiDAOList.get(0).getTagName());
            List<EmojiDTO> emojiDTOS = new ArrayList<>();
            for (EmojiDAO emojiDAO : emojiDAOList) {
                EmojiDTO emojiDTO = new EmojiDTO(emojiDAO.getEmojiTag(), emojiDAO.getEmojiUrl(), emojiDAO.getSetNum());
                emojiDTOS.add(emojiDTO);
            }
            requestClientEmojiDTO.setEmojiDTOS(emojiDTOS);
        }else if(imageDAO.getStatus() == null){
            requestClientEmojiDTO.setStatus(StatusType.NOTVALUE);
        }else{
            requestClientEmojiDTO.setStatus(imageDAO.getStatus());
        }
        return requestClientEmojiDTO;
    }
}
