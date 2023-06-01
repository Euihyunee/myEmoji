package com.emojiMaker.BackEnd.Model.DTO.EmojiDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EmojiDTO {

    private String requestId;
    private String tagName;
    private List<EmojiImgDTO> emojiImgDTOS;
}
