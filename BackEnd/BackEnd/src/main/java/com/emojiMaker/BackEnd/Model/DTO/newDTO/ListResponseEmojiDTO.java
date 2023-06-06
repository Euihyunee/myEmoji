package com.emojiMaker.BackEnd.Model.DTO.newDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ListResponseEmojiDTO {

    private List<ResponseEmojiDTO> responseEmojiDTOS;
}
