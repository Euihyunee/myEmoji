package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Bean.SmallBean.MapStyleDAOBean;
import com.emojiMaker.BackEnd.Bean.SmallBean.UpdateStatusBean;
import com.emojiMaker.BackEnd.Model.DAO.StyleDAO;
import com.emojiMaker.BackEnd.Model.DTO.Image.ImageDTO;
import com.emojiMaker.BackEnd.Model.DTO.Style.StyleDTO;
import com.emojiMaker.BackEnd.Model.DTO.Style.TagDTO;
import com.emojiMaker.BackEnd.Repository.ImageDTORepository;
import com.emojiMaker.BackEnd.Repository.StyleDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
public class Image2Bean {

    /* TODO 도건 Server에서 request_id, {img_url, tag_name}s 날아옴
        1. request_id로 status 조회
        2. status 수정 (enum 타입)
        3. DAO에 매핑
        4. DB에 DAO 저장
        # DAO : id, img_url, tag_name, request_id / tag 개수만큼 생김 */
    @Autowired
    MapStyleDAOBean mapStyleDAOBean;
    @Autowired
    ImageDTORepository imageDTORepository;
    @Autowired
    StyleDAORepository styleDAORepository;
    @Autowired
    UpdateStatusBean updateStatusBean;

    public void exec(StyleDTO styleDTO) {

        String requestId = styleDTO.getRequestId();
        List<TagDTO> tagDTOS = styleDTO.getStyles();
        ImageDTO imageDTO = imageDTORepository.findImageDTOByRequestId(requestId);

        if (!StringUtils.isEmpty(imageDTO)){
            imageDTORepository.save( updateStatusBean.exec(imageDTO, 1));
            List<StyleDAO> styleDAOS = mapStyleDAOBean.exec(requestId, tagDTOS);
            styleDAORepository.saveAll(styleDAOS);
        } else System.out.println("null임");
    }

}
