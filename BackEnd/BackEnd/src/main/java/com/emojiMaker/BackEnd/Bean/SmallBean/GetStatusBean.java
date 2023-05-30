package com.emojiMaker.BackEnd.Bean.SmallBean;

import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import org.springframework.stereotype.Component;

@Component
public class GetStatusBean {

    // TODO Status 가져오는 빈
    public StatusType exec(){
        StatusType statusType = StatusType.WAITIMG;

        return statusType;
    }
}
