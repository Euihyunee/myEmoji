package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Bean.SmallBean.UpdateStatusBean;
import com.emojiMaker.BackEnd.Model.DAO.StyleDAO;
import com.emojiMaker.BackEnd.Model.DTO.Image.ImageDTO;
import com.emojiMaker.BackEnd.Repository.ImageDTORepository;
import com.emojiMaker.BackEnd.Repository.StyleDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Style1Bean {

    /* TODO Client 화풍 선택 request_id, tag_name이 들어옴
        도건 Server에 요청, status 수정
        request_id, tag_name 반환
        status 수정 */
    @Autowired
    StyleDAORepository styleDAORepository;
    @Autowired
    ImageDTORepository imageDTORepository;
    @Autowired
    UpdateStatusBean updateStatusBean;

    public void exec(String requestId, String tagName){
        StyleDAO styleDAO = styleDAORepository.findStyleDAOByRequestIdAndTagName(requestId, tagName);
        if (styleDAO != null) {
            ImageDTO imageDTO = imageDTORepository.findImageDTOByRequestId(requestId);
            imageDTORepository.save(updateStatusBean.exec(imageDTO, 2));
        }
    }
}
