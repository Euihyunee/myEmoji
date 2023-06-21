package com.emojiMaker.BackEnd.Bean.SmallBean;

import com.emojiMaker.BackEnd.Model.DAO.ImageDAO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetStatusBean {

    @Autowired
    ImageDAORepository imageDAORepository;

    // TODO Status 가져오는 빈
    public StatusType exec(){
        StatusType statusType = StatusType.WAITTAG;

        return statusType;
    }
    public StatusType exec(String requestId){
        ImageDAO imageDAO = imageDAORepository.findImageDAOByRequestId(requestId);
        return imageDAO.getStatus();
    }
}
