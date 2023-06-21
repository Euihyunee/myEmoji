package com.emojiMaker.BackEnd.Bean.SmallBean;

import com.emojiMaker.BackEnd.Model.DAO.TagDAO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.ResponseTagDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class MapStyleDAOBean {

    public List<TagDAO> exec(String requestId, List<ResponseTagDTO> responseTagDTOS){

        List<TagDAO> tagDAOS = new ArrayList<>();
        for(ResponseTagDTO responseTagDTO : responseTagDTOS){
            TagDAO tagDAO = new TagDAO(requestId,
                    responseTagDTO.getTagName(),
                    responseTagDTO.getTagUrl(),
                    responseTagDTO.getSetNum());
            tagDAOS.add(tagDAO);
        }
        return tagDAOS;
    }

}
