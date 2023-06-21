package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Model.DAO.EmojiDAO;
import com.emojiMaker.BackEnd.Repository.EmojiDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class User4Bean {

    @Autowired
    EmojiDAORepository emojiDAORepository;

    public Object exec(String requestId) {
        List<EmojiDAO> emojiDAOS = emojiDAORepository.findAllByRequestId(requestId);
        return emojiDAOS;
    }
}
