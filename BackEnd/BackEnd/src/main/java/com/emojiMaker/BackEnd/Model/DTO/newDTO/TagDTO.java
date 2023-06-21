package com.emojiMaker.BackEnd.Model.DTO.newDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TagDTO {

    public TagDTO(String tagName, String tagUrl, int setNum) {
        this.tagName = tagName;
        this.tagUrl = tagUrl;
        this.setNum = setNum;
    }
    private String tagName;
    private String tagUrl;
    private int setNum;
}
