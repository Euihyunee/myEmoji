package com.emojiMaker.BackEnd.Model.DTO.Style;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Style1DTO {

    private String requestId;
    private List<StyleDTO> styles;
}
