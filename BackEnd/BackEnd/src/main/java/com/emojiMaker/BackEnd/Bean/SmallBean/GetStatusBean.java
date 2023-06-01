package com.emojiMaker.BackEnd.Bean.SmallBean;

import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Repository.ImageDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetStatusBean {

    @Autowired
    ImageDTORepository imageDTORepository;

    // TODO Status 가져오는 빈
    public StatusType exec(){
        StatusType statusType = StatusType.WAITIMG;

        return statusType;
    }
    public StatusType exec(String requestId){
        StatusType statusType = imageDTORepository.findByRequestId(requestId);

        return statusType;
    }
}
