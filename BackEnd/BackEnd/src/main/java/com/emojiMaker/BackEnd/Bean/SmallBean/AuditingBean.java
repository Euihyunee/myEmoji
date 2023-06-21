package com.emojiMaker.BackEnd.Bean.SmallBean;

import com.emojiMaker.BackEnd.Model.DAO.UserDAO;
import com.emojiMaker.BackEnd.Repository.UserDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class AuditingBean {

    @Autowired
    UserDAORepository userDAORepository;

    public boolean exec(String userId){
        System.out.println("adsfjkhaskfash");

        LocalDateTime localDateTime = LocalDateTime.now();
//        UserDAO userDAO = userDAORepository.findByUserId(userId);
        System.out.println("adsfjkhaskfash");
//        Duration duration = Duration.between(userDAO.getModifiedDate(),localDateTime);
//        System.out.println(duration.getSeconds());
//        if (duration.getSeconds() < 10){
//            return false;
//        }
        return true;
    }
}
