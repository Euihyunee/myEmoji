package com.emojiMaker.BackEnd.Service;

import com.emojiMaker.BackEnd.Bean.Style3Bean;
import com.emojiMaker.BackEnd.Model.DTO.Style.StyleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StyleService {

    @Autowired
    Style3Bean style3Bean;

    public StyleDTO exec(String requestId){
        return style3Bean.exec(requestId);
    }
}
