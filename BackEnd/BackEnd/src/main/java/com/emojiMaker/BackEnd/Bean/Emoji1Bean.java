package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Bean.SmallBean.MapEmojiDAOBean;
import com.emojiMaker.BackEnd.Bean.SmallBean.UpdateStatusBean;
import com.emojiMaker.BackEnd.Model.DAO.EmojiDAO;
import com.emojiMaker.BackEnd.Model.DTO.Image.ImageDAO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.ListResponseEmojiDTO;
import com.emojiMaker.BackEnd.Repository.EmojiDAORepository;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Emoji1Bean {

    @Autowired
    ImageDAORepository imageDAORepository;
    @Autowired
    UpdateStatusBean updateStatusBean;
    @Autowired
    MapEmojiDAOBean mapEmojiDAOBean;
    @Autowired
    EmojiDAORepository emojiDAORepository;

    public void exec(ListResponseEmojiDTO listResponseEmojiDTO){
        //TODO Status 변경
        String requestId = listResponseEmojiDTO.getResponseEmojiDTOS().get(0).getRequestId();
        String tagName = listResponseEmojiDTO.getResponseEmojiDTOS().get(0).getTagName();
        ImageDAO imageDAO = imageDAORepository.findImageDAOByRequestId(requestId);
        imageDAORepository.save(updateStatusBean.exec(imageDAO, 3));
        List<EmojiDAO> emojiDAOList = mapEmojiDAOBean.exec(requestId, tagName, listResponseEmojiDTO.getResponseEmojiDTOS());

        emojiDAORepository.saveAll(emojiDAOList);
    }

}
