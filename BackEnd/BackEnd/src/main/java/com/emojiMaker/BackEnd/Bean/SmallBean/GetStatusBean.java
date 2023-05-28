package com.emojiMaker.BackEnd.Bean.SmallBean;

import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Repository.ImgRepository;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetStatusBean {

    // TODO Status 가져오는 빈
    public StatusType exec(){
        StatusType statusType = StatusType.WAITIMG;

        return statusType;
    }
}
