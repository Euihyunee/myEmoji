package com.emojiMaker.BackEnd.Bean.SmallBean;

import com.emojiMaker.BackEnd.Model.DAO.EmojiDAO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.ResponseEmojiDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapEmojiDAOBean {

    public List<EmojiDAO> exec(String emojiRequestId,String requestId, String tagName, List<ResponseEmojiDTO> responseEmojiDTOS) {

        List<EmojiDAO> emojiDAOS = new ArrayList<>();
        for (ResponseEmojiDTO responseEmojiDTO : responseEmojiDTOS) {
            EmojiDAO emojiDAO = new EmojiDAO(emojiRequestId,
                    requestId,
                    tagName,
                    responseEmojiDTO.getEmojiUrl(),
                    responseEmojiDTO.getEmojiTag(),
                    responseEmojiDTO.getSetNum());

            emojiDAOS.add(emojiDAO);
        }
        System.out.println(emojiDAOS);
        return emojiDAOS;
    }
}
