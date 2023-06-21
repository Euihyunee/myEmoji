package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Bean.SmallBean.GetStatusBean;
import com.emojiMaker.BackEnd.Model.DAO.TagDAO;
import com.emojiMaker.BackEnd.Model.DAO.ImageDAO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.TagDTO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.RequestClientTagDTO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import com.emojiMaker.BackEnd.Repository.TagDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Tag3Bean {

    @Autowired
    ImageDAORepository imageDAORepository;
    @Autowired
    TagDAORepository tagDAORepository;
    @Autowired
    GetStatusBean getStatusBean;

    public RequestClientTagDTO exec(String requestId) {

        ImageDAO imageDAO = imageDAORepository.findImageDAOByRequestId(requestId);
        StatusType statusType = imageDAO.getStatus();

        //TODO 아직 AI response 없을 때 status, wait 반환
        RequestClientTagDTO requestClientTagDTO = new RequestClientTagDTO();
        requestClientTagDTO.setStatus(statusType);
        requestClientTagDTO.setWait(imageDAO.getWait());
        requestClientTagDTO.setRequestId(requestId);
        System.out.println(statusType);

        // TODO wait 100일때 매핑
        if (imageDAO.getWait() == 100) {
            List<TagDTO> tagDTOS = new ArrayList<>();
            List<TagDAO> tagDAOList = tagDAORepository.findAllByRequestId(requestId);
            for (TagDAO tagDAO : tagDAOList) {
                TagDTO tagDTO = new TagDTO(tagDAO.getTagName(),
                        tagDAO.getTagUrl(), tagDAO.getSetNum());
                tagDTOS.add(tagDTO);
            }
            requestClientTagDTO.setTagDTOS(tagDTOS);
            return requestClientTagDTO;
        }
        return requestClientTagDTO;
    }
}
