package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Model.DAO.ImageDAO;
import com.emojiMaker.BackEnd.Model.DAO.RequestEmojiDAO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Tag2Bean {

    @Autowired
    ImageDAORepository imageDAORepository;

    public void exec(int wait, String requestId) {
        ImageDAO imageDAO = imageDAORepository.findImageDAOByRequestId(requestId);
        imageDAO.setWait(wait);
        if (wait == 100) {
            log.info("로딩 데이터 Wait이 100%일 때 요청 상태(Status) 변경");
            imageDAO.setStatus(StatusType.COMPLETETAG);
            log.info("요청 데이터 상태(Status) : " + imageDAO.getStatus());
        }
        imageDAORepository.save(imageDAO);
    }
}
