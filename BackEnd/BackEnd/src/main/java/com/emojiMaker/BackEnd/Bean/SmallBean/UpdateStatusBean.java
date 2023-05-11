package com.emojiMaker.BackEnd.Bean.SmallBean;

import com.emojiMaker.BackEnd.Model.Enum.StatusType;

public class UpdateStatusBean {

    // TODO Status Update 빈
    public StatusType exec() {
        return StatusType.WAITIMG;
    }
    public StatusType exec(StatusType status, int statusNum){
        if (statusNum == 1) {
            status = StatusType.COMPLETESTYLE;
        } else if (statusNum == 2) {
            status = StatusType.WAITSTYLE;
        } else if (statusNum == 3) {
            status = StatusType.COMPLETESTYLE;
        }
        return status;
    }
}
