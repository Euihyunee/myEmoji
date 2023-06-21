package com.emojiMaker.BackEnd.Service;

import com.emojiMaker.BackEnd.Bean.Tag1Bean;
import com.emojiMaker.BackEnd.Bean.Tag2Bean;
import com.emojiMaker.BackEnd.Bean.Tag3Bean;
import com.emojiMaker.BackEnd.Bean.testTagBean;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.RequestClientTagDTO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.RequestUrlEmojiDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TagService {

    @Autowired
    Tag3Bean tag3Bean;
    @Autowired
    Tag1Bean tag1Bean;
    @Autowired
    testTagBean testTagBean;
    @Autowired
    Tag2Bean tag2Bean;

    public RequestUrlEmojiDTO exec1(String userId, String requestId, String tagName, int setNum){
        RequestUrlEmojiDTO requestUrlEmojiDTO = tag1Bean.exec(userId, requestId, tagName, setNum);
        return requestUrlEmojiDTO;
    }

    public RequestClientTagDTO exec3(String requestId){
        return tag3Bean.exec(requestId);
    }

    public void saveTagLoading(int wait, String requestId) {
        log.info("로딩 데이터 ImageDAO에 UPDATE");
        tag2Bean.exec(wait, requestId);
    }
}
