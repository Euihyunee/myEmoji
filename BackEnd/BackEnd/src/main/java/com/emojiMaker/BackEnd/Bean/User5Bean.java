package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Model.DAO.UserDAO;
import com.emojiMaker.BackEnd.Repository.UserDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User5Bean {

    @Autowired
    UserDAORepository userDAORepository;

    public UserDAO exec(String userId, String nickname) {
        UserDAO userDAO = userDAORepository.findByUserId(userId);
        userDAO.setNickName(nickname);
        userDAORepository.save(userDAO);
        return userDAO;
    }
}
