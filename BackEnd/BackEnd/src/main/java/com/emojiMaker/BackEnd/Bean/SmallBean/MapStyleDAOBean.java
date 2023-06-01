package com.emojiMaker.BackEnd.Bean.SmallBean;

import com.emojiMaker.BackEnd.Model.DAO.StyleDAO;
import com.emojiMaker.BackEnd.Model.DTO.Style.StyleDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapStyleDAOBean {

    public List<StyleDAO> exec(String requestId, List<StyleDTO> styleDTOList){

        List<StyleDAO> styleDAOS = new ArrayList<>();
        for(StyleDTO styleDTO : styleDTOList){
            StyleDAO styleDAO = new StyleDAO(styleDTO.getImgUrl(), styleDTO.getTagName(), requestId);
            styleDAOS.add(styleDAO);
        }
        return styleDAOS;
    }

}
