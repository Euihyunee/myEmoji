package com.emojiMaker.BackEnd.Model.DTO.Style;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestTagDTO {

    public RequestTagDTO(String requestId, String tagName) {
        this.requestId = requestId;
        this.tagName = tagName;
    }

    private String requestId;
    private String tagName;
}
