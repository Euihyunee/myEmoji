package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Bean.SmallBean.MapEmojiDAOBean;
import com.emojiMaker.BackEnd.Bean.SmallBean.UpdateStatusBean;
import com.emojiMaker.BackEnd.Model.DAO.EmojiDAO;
import com.emojiMaker.BackEnd.Model.DTO.EmojiDTO.EmojiDTO;
import com.emojiMaker.BackEnd.Model.DTO.Image.ImageDTO;
import com.emojiMaker.BackEnd.Repository.EmojiDAORepository;
import com.emojiMaker.BackEnd.Repository.ImageDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Emoji1Bean {

    @Autowired
    ImageDTORepository imageDTORepository;
    @Autowired
    UpdateStatusBean updateStatusBean;
    @Autowired
    MapEmojiDAOBean mapEmojiDAOBean;
    @Autowired
    EmojiDAORepository emojiDAORepository;

    public void exec(EmojiDTO emojiDTO){
        //TODO Status 변경
        String requestId = emojiDTO.getRequestId();
        String tagName = emojiDTO.getTagName();
        ImageDTO imageDTO = imageDTORepository.findImageDTOByRequestId(requestId);
        imageDTORepository.save(updateStatusBean.exec(imageDTO, 3));
        List<EmojiDAO> emojiDAOList = mapEmojiDAOBean.exec(requestId, tagName, emojiDTO.getEmojiImgDTOS());

        emojiDAORepository.saveAll(emojiDAOList);
    }

}
