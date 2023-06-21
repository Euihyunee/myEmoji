package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Model.DAO.ImageDAO;
import com.emojiMaker.BackEnd.Model.DAO.RequestEmojiDAO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tag2Bean {

    @Autowired
    ImageDAORepository imageDAORepository;

    public void exec(int wait, String requestId) {
        ImageDAO imageDAO = imageDAORepository.findImageDAOByRequestId(requestId);
        imageDAO.setWait(wait);
        if (wait == 100) {
            imageDAO.setStatus(StatusType.COMPLETETAG);
        }
        imageDAORepository.save(imageDAO);
    }
}
