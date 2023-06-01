package com.emojiMaker.BackEnd.Bean.SmallBean;

import com.emojiMaker.BackEnd.Model.DTO.Image.ImageDTO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import org.springframework.stereotype.Component;

@Component
public class UpdateStatusBean {

    // TODO Status Update 빈
    public StatusType exec() {
        return StatusType.WAITIMG;
    }
    public ImageDTO exec(ImageDTO imageDTO, int statusNum){
        if (statusNum == 1) {
            imageDTO.setStatus(StatusType.COMPLETEIMG);
        } else if (statusNum == 2) {
            imageDTO.setStatus(StatusType.WAITSTYLE);
        } else if (statusNum == 3) {
            imageDTO.setStatus(StatusType.COMPLETESTYLE);
        }
        return imageDTO;
    }
}
