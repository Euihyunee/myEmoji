package com.emojiMaker.BackEnd.Service;

import com.emojiMaker.BackEnd.Model.Enum.TagType;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    // 디비에 STP 요청정보 저장
    public boolean requestStp(){

        // 디비에 저장되면 ture 리턴
        return true;
    }

    // 디비에 PTP 요청정보 저장
    public boolean requestPtp(){

        // 디비에 저장되면 ture 리턴
        return true;
    }

    // 리쿼스트 with type
    public void requestAIWithType(TagType TagType, long requestId){
        // 태그타입과 requestid를 디비에 저장

    }

    // 디비에 저장된 요청정보 확인



}
