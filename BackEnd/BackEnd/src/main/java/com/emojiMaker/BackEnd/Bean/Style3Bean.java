package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Bean.SmallBean.GetStatusBean;
import com.emojiMaker.BackEnd.Model.DAO.StyleDAO;
import com.emojiMaker.BackEnd.Model.DTO.Style.StyleDTO;
import com.emojiMaker.BackEnd.Model.DTO.Style.TagDTO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Repository.ImageDTORepository;
import com.emojiMaker.BackEnd.Repository.StyleDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Component
public class Style3Bean {

    @Autowired
    ImageDTORepository imageDTORepository;
    @Autowired
    StyleDAORepository styleDAORepository;
    @Autowired
    GetStatusBean getStatusBean;

    public StyleDTO exec(String requestId) {
        StatusType statusType = getStatusBean.exec(requestId);
        if (statusType == StatusType.COMPLETEIMG) {
            StyleDTO styleDTO = new StyleDTO();
            List<TagDTO> tagDTOS = new ArrayList<>();
            styleDTO.setRequestId(requestId);

            List<StyleDAO> styleDAOList = styleDAORepository.findAllByRequestId(requestId);

            for (StyleDAO styleDAO : styleDAOList) {
                TagDTO tagDTO = new TagDTO(styleDAO.getTagName(), styleDAO.getImgUrl());
                tagDTOS.add(tagDTO);
            }
            styleDTO.setStyles(tagDTOS);
            return styleDTO;
        }
        return null;
    }
}
