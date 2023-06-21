package com.emojiMaker.BackEnd.Bean.SmallBean;

import com.emojiMaker.BackEnd.Model.DAO.ImageDAO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import org.springframework.stereotype.Component;

@Component
public class UpdateStatusBean {

    // TODO Status Update 빈
    public StatusType exec() {
        return StatusType.WAITTAG;
    }
    public ImageDAO exec(ImageDAO imageDAO, int statusNum){
        if (statusNum == 1) {
            imageDAO.setStatus(StatusType.COMPLETETAG);
        } else if (statusNum == 2) {
            imageDAO.setStatus(StatusType.WAITEMOJI);
        } else if (statusNum == 3) {
            imageDAO.setStatus(StatusType.COMPLETEEMOJI);
        }
        return imageDAO;
    }
}
