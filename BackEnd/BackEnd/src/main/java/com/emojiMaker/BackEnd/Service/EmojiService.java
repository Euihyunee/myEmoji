package com.emojiMaker.BackEnd.Service;

import com.emojiMaker.BackEnd.Bean.Emoji1Bean;
import com.emojiMaker.BackEnd.Bean.Emoji2Bean;
import com.emojiMaker.BackEnd.Model.DTO.EmojiDTO.EmojiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmojiService {

    @Autowired
    Emoji1Bean emoji1Bean;
    @Autowired
    Emoji2Bean emoji2Bean;

    public void responseExec(EmojiDTO emojiDTO) {
        emoji1Bean.exec(emojiDTO);
    }

    public String getExec(String requestId){
        return emoji2Bean.exec(requestId);
    }

}
