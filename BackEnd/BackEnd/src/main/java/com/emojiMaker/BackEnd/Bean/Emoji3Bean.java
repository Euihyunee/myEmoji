package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Model.DAO.RequestEmojiDAO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Repository.RequestEmojiDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Emoji3Bean {

    @Autowired
    RequestEmojiDAORepository requestEmojiDAORepository;

    public void exec(int wait, String emojiRequestId){
        RequestEmojiDAO requestEmojiDAO = requestEmojiDAORepository.findByEmojiRequestId(emojiRequestId);
        requestEmojiDAO.setWait(wait);
        if (wait == 100) {
            requestEmojiDAO.setStatusType(StatusType.COMPLETEEMOJI);
        }
        requestEmojiDAORepository.save(requestEmojiDAO);
    }
}
