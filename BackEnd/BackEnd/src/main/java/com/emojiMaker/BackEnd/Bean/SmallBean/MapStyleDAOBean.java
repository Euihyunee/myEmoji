package com.emojiMaker.BackEnd.Bean.SmallBean;

import com.emojiMaker.BackEnd.Model.DAO.StyleDAO;
import com.emojiMaker.BackEnd.Model.DTO.Style.StyleTagDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapStyleDAOBean {

    public List<StyleDAO> exec(String requestId, List<StyleTagDTO> styleTagDTOList){

        List<StyleDAO> styleDAOS = new ArrayList<>();
        for(StyleTagDTO styleTagDTO : styleTagDTOList){
            StyleDAO styleDAO = new StyleDAO(styleTagDTO.getImgUrl(), styleTagDTO.getTagName(), requestId);
            styleDAOS.add(styleDAO);
        }
        return styleDAOS;
    }

}
