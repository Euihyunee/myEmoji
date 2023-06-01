package com.emojiMaker.BackEnd.Bean.SmallBean;

import com.emojiMaker.BackEnd.Model.DAO.EmojiDAO;
import com.emojiMaker.BackEnd.Model.DTO.EmojiDTO.EmojiImgDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapEmojiDAOBean {

    public List<EmojiDAO> exec(String requestId, String tagName, List<EmojiImgDTO> emojiImgDTOS) {

        List<EmojiDAO> emojiDAOS = new ArrayList<>();
        for (EmojiImgDTO emojiImgDTO : emojiImgDTOS) {
            EmojiDAO emojiDAO = new EmojiDAO(requestId, tagName, emojiImgDTO.getEmojiUrl(), emojiImgDTO.getEmojiTag());
            emojiDAOS.add(emojiDAO);
        }
        return emojiDAOS;
    }
}
