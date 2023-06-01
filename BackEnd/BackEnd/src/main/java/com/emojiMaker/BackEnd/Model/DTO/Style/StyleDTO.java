package com.emojiMaker.BackEnd.Model.DTO.Style;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StyleDTO {

    private String requestId;
    private List<StyleTagDTO> styles;
}
