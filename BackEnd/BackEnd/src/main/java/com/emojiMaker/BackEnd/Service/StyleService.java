package com.emojiMaker.BackEnd.Service;

import com.emojiMaker.BackEnd.Bean.Style1Bean;
import com.emojiMaker.BackEnd.Bean.Style3Bean;
import com.emojiMaker.BackEnd.Model.DTO.Style.StyleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StyleService {

    @Autowired
    Style3Bean style3Bean;
    @Autowired
    Style1Bean style1Bean;

    public void exec1(String requestId, String tagName){
        style1Bean.exec(requestId, tagName);
    }

    public StyleDTO exec3(String requestId){
        return style3Bean.exec(requestId);
    }
}
