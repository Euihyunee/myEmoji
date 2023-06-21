package com.emojiMaker.BackEnd.Model.DTO.newDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestEmojiLoadDTO {
    private int wait;
    private String EmojiRequestId;
}
