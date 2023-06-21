package com.emojiMaker.BackEnd.Service;

import com.emojiMaker.BackEnd.Bean.Emoji1Bean;
import com.emojiMaker.BackEnd.Bean.Emoji2Bean;
import com.emojiMaker.BackEnd.Bean.Emoji3Bean;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.ListResponseEmojiDTO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.RequestClientEmojiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmojiService {

    @Autowired
    Emoji1Bean emoji1Bean;
    @Autowired
    Emoji2Bean emoji2Bean;
    @Autowired
    Emoji3Bean emoji3Bean;

    public void responseExec(ListResponseEmojiDTO listResponseEmojiDTO) {
        emoji1Bean.exec(listResponseEmojiDTO);
    }

    public RequestClientEmojiDTO getExec(String emojiRequestId){
        return emoji2Bean.exec(emojiRequestId);
    }

    public void saveEmojiLoading(int wait, String emojiRequestId) {
        emoji3Bean.exec(wait, emojiRequestId);
    }
}
