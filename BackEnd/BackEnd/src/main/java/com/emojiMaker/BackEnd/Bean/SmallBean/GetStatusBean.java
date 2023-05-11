package com.emojiMaker.BackEnd.Bean.SmallBean;

import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Repository.ImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetStatusBean {

    @Autowired
    ImgRepository imgRepository;

    // TODO Status 가져오는 빈
    public StatusType exec(Long requestId) {
        return imgRepository.findByRequestId(requestId);
    }
}
