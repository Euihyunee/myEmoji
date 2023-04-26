package com.emojiMaker.BackEnd.Model.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEmojiResultDTO {

    List<ResponseEmojiDTO> emoji1;
    List<ResponseEmojiDTO> emoji2;
    List<ResponseEmojiDTO> emoji3;
}
