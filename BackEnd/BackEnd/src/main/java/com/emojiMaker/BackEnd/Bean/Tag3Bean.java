package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Bean.SmallBean.GetStatusBean;
import com.emojiMaker.BackEnd.Model.DAO.TagDAO;
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

        StatusType statusType = getStatusBean.exec(requestId);
        RequestClientTagDTO requestClientTagDTO = new RequestClientTagDTO();
        requestClientTagDTO.setStatus(statusType);
        System.out.println(statusType);
        if (statusType == StatusType.COMPLETETAG) {
            List<TagDTO> tagDTOS = new ArrayList<>();
            requestClientTagDTO.setRequestId(requestId);

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
