package com.emojiMaker.BackEnd.Bean.SmallBean;

import com.emojiMaker.BackEnd.Model.DAO.ImageDAO;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class TagAuditingBean {

    @Autowired
    ImageDAORepository imageDAORepository;

    public boolean exec(String userId){
        if (imageDAORepository.existsImageDAOByUserId(userId)) {
            LocalDateTime localDateTime = LocalDateTime.now();
            ImageDAO imageDAO = imageDAORepository.findFirstByUserIdOrderByCreatedDateDesc(userId);
            Duration duration = Duration.between(imageDAO.getCreatedDate(), localDateTime);
            return duration.getSeconds() >= 10;
        }
        return true;
    }
}
