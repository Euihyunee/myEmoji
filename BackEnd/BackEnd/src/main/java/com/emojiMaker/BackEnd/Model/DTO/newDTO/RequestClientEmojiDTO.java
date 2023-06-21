package com.emojiMaker.BackEnd.Model.DTO.newDTO;

import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RequestClientEmojiDTO {

    private String requestId;
    private String tagName;
    private StatusType status;

    private List<EmojiDTO> emojiDTOS;
}
