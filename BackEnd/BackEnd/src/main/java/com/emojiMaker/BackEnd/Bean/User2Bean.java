package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Model.DAO.ImageDAO;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class User2Bean {

    @Autowired
    ImageDAORepository imageDAORepository;

    public Object exec(String userId) {
        List<ImageDAO> imageDAOS = imageDAORepository.findAllByUserId(userId);

        return imageDAOS;
    }
}
