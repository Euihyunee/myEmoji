package com.emojiMaker.BackEnd.Model.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseEmojiDTO {
    String emojiUrl;
    String emojiName;
}
