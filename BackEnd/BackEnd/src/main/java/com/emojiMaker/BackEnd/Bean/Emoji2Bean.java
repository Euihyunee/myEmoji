package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Model.DTO.Image.ImageDTO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Repository.ImageDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Emoji2Bean {

    @Autowired
    ImageDTORepository imageDTORepository;
    public String exec(String requestId){
        ImageDTO imageDTO = imageDTORepository.findImageDTOByRequestId(requestId);
        String answer = "미완성";
        if (imageDTO.getStatus() == StatusType.COMPLETESTYLE) {
            answer = "완성 기둘";
            // TODO 나머지 로직 ㄱㄱ
        }
        
        return answer;
    }
}
