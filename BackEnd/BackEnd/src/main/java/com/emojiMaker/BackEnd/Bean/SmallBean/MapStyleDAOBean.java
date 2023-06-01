package com.emojiMaker.BackEnd.Bean.SmallBean;

import com.emojiMaker.BackEnd.Model.DAO.StyleDAO;
import com.emojiMaker.BackEnd.Model.DTO.Style.TagDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapStyleDAOBean {

    public List<StyleDAO> exec(String requestId, List<TagDTO> tagDTOList){

        List<StyleDAO> styleDAOS = new ArrayList<>();
        for(TagDTO tagDTO : tagDTOList){
            StyleDAO styleDAO = new StyleDAO(tagDTO.getImgUrl(), tagDTO.getTagName(), requestId);
            styleDAOS.add(styleDAO);
        }
        return styleDAOS;
    }

}
