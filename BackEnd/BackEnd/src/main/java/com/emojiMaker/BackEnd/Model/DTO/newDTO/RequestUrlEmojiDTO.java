package com.emojiMaker.BackEnd.Model.DTO.newDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestUrlEmojiDTO {

    private String imgName;
    private int setNum;
    private String emojiRequestId;
}
