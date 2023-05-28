package com.emojiMaker.BackEnd.Bean.SmallBean;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

@Component
public class GetRequestIdBean {

    // TODO request_id 생성하는 빈
    public String exec(){
        LocalDateTime localDateTime = LocalDateTime.now();
        String parseLocalDateTime = localDateTime.format(DateTimeFormatter.ofPattern(
                "yyyy-MM-dd HH:mm:ss"));
        Logger.getLogger("requestId는 "+parseLocalDateTime + " 와 같다.");
        return parseLocalDateTime;
    }
}
