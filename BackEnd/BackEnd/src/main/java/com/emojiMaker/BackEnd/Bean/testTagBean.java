package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Model.DAO.ImageDAO;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class testTagBean {

    @Autowired
    ImageDAORepository imageDAORepository;

    public void exec(String requestId, int wait){
        ImageDAO imageDAO = imageDAORepository.findImageDAOByRequestId(requestId);
        imageDAO.setWait(wait);
        imageDAORepository.save(imageDAO);
    }
}
