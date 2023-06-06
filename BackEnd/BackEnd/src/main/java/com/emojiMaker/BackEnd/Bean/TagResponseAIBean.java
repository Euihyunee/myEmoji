package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Bean.SmallBean.MapStyleDAOBean;
import com.emojiMaker.BackEnd.Bean.SmallBean.UpdateStatusBean;
import com.emojiMaker.BackEnd.Model.DAO.TagDAO;
import com.emojiMaker.BackEnd.Model.DTO.Image.ImageDAO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.ListResponseTagDTO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.ResponseTagDTO;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import com.emojiMaker.BackEnd.Repository.TagDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
public class TagResponseAIBean {

    /* TODO 도건 Server에서 request_id, {img_url, tag_name}s 날아옴
        1. request_id로 status 조회
        2. status 수정 (enum 타입)
        3. DAO에 매핑
        4. DB에 DAO 저장
        # DAO : id, img_url, tag_name, request_id / tag 개수만큼 생김 */
    @Autowired
    MapStyleDAOBean mapStyleDAOBean;
    @Autowired
    ImageDAORepository imageDAORepository;
    @Autowired
    TagDAORepository tagDAORepository;
    @Autowired
    UpdateStatusBean updateStatusBean;

    public void exec(ListResponseTagDTO listResponseTagDTO) {

        // TODO requestId 뽑아냄
        String requestId = listResponseTagDTO.getResponseTagDTOS().get(0).getRequestId();
        // TODO List형식으로 변경
        List<ResponseTagDTO> responseTagDTOS = listResponseTagDTO.getResponseTagDTOS();
        // TODO ImageDTO 뽑아내기(vaile 검사용)
        ImageDAO imageDAO = imageDAORepository.findImageDAOByRequestId(requestId);



        if (!StringUtils.isEmpty(imageDAO)){
            imageDAORepository.save( updateStatusBean.exec(imageDAO, 1));
            List<TagDAO> tagDAOS = mapStyleDAOBean.exec(requestId, responseTagDTOS);
            tagDAORepository.saveAll(tagDAOS);
        } else System.out.println("null임");
    }

}
