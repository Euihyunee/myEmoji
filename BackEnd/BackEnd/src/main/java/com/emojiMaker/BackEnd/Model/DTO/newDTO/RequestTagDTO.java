package com.emojiMaker.BackEnd.Model.DTO.newDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestTagDTO {

    public RequestTagDTO(String requestId, String imgName) {
        this.requestId = requestId;
        this.imgName = imgName;
    }

    private String requestId;
    private String imgName;
}
