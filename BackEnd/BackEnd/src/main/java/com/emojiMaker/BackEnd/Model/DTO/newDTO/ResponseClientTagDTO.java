package com.emojiMaker.BackEnd.Model.DTO.newDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponseClientTagDTO {

    private String requestId;
    private String userId;
    private List<TagDTO> tagDTOS;

}
