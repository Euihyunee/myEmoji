package com.emojiMaker.BackEnd.Model.DTO.newDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmojiDTO {

    private String emojiTag;

    public EmojiDTO(String emojiTag, String emojiUrl, int setNum) {
        this.emojiTag = emojiTag;
        this.emojiUrl = emojiUrl;
        this.setNum = setNum;
    }

    private String emojiUrl;
    private int setNum;
}
