package com.emojiMaker.BackEnd.Model.DTO.newDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseTagDTO {

    private String requestId;
    private String tagName;
    private String tagUrl;
    private int setNum;
}
