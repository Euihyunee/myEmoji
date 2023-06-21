package com.emojiMaker.BackEnd.Model.DTO.newDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseEmojiDTO {

    private String emojiRequestId;
    private String requestId;
    private String tagName;
    private String emojiTag;
    private String emojiUrl;
    private int setNum;
}
