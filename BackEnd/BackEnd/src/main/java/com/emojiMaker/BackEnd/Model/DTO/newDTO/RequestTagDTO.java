package com.emojiMaker.BackEnd.Model.DTO.newDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RequestTagDTO {

    public RequestTagDTO(String requestId, String imgName) {
        this.requestId = requestId;
        this.imgName = imgName;
    }

    private String requestId;
    private String imgName;
}
