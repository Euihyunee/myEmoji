package com.emojiMaker.BackEnd.Service;

import com.emojiMaker.BackEnd.Model.DTO.RequestUserInputDTO;
import com.emojiMaker.BackEnd.Model.Enum.RequestType;
import com.emojiMaker.BackEnd.Model.Enum.TagType;
import com.emojiMaker.BackEnd.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
    @Autowired
    RequestRepository repository;

    // 디비에 STP 요청정보 저장
    public boolean requestStp(long requestId){
//        RequestUserInputDTO requestUserInputDTO = new RequestUserInputDTO(requestId, RequestType.STP, "");
//
//        // 디비에 저장되면 ture 리턴
//        return repository.save(requestUserInputDTO);
        return true;
    }

    // 디비에 PTP 요청정보 저장
    public boolean requestPtp(long requestId){
//        RequestUserInputDTO requestUserInputDTO = new RequestUserInputDTO(requestId, RequestType.PTP,"");
//
//        // 디비에 저장되면 ture 리턴
//        return repository.save(requestUserInputDTO);
        return true;
    }

    // 리쿼스트 with type
    public void requestAIWithType(TagType TagType, long requestId){
        // 태그타입과 requestid를 디비에 저장

    }

    // 디비에 저장된 요청정보 확인



}
