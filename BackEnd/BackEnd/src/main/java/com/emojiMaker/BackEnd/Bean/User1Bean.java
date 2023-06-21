package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Model.DAO.UserDAO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.UserInfoDTO;
import com.emojiMaker.BackEnd.Repository.UserDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User1Bean {

    @Autowired
    UserDAORepository userDAORepository;

    public Object exec(String userId) {
        UserDAO userDAO = userDAORepository.findByUserId(userId);
        UserInfoDTO userInfoDTO = new UserInfoDTO(
                userDAO.getUserId(),
                userDAO.getEmail(),
                userDAO.getPicture(),
                userDAO.getNickName()
        );

        return userInfoDTO;
    }
}
