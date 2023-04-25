package com.emojiMaker.BackEnd.Model.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseTagImageDTO {
    String tagName;
    String imgUrl;

}
