package com.emojiMaker.BackEnd.Model.DTO.Style;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TagDTO {

    private String tagName;
    private String imgUrl;

    public TagDTO(String tagName, String imgUrl) {
        this.tagName = tagName;
        this.imgUrl = imgUrl;
    }
}
