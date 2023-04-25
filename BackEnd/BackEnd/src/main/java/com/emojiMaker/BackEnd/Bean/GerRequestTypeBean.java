package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Model.Enum.RequestType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Slf4j
public class GerRequestTypeBean {
    public RequestType exec(String requestType){
        switch (requestType.toLowerCase()){
            case "stp" :
                return RequestType.STP;
            case "ptp":
                return RequestType.PTP;
        }
        log.error("GerRequestTypeBean 빈의 인풋이 null 입니다");

        return null;
    }
}
