package com.emojiMaker.BackEnd.Model.DTO;

import com.emojiMaker.BackEnd.Model.Enum.RequestType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestUserInputDTO {
    private Long requestId;
    RequestType requestType;


}
