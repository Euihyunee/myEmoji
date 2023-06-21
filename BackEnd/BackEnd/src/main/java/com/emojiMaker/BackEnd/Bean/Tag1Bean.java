package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Bean.SmallBean.UpdateStatusBean;
import com.emojiMaker.BackEnd.Model.DAO.RequestEmojiDAO;
import com.emojiMaker.BackEnd.Model.DAO.TagDAO;
import com.emojiMaker.BackEnd.Model.DAO.ImageDAO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.RequestUrlEmojiDTO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import com.emojiMaker.BackEnd.Repository.RequestEmojiDAORepository;
import com.emojiMaker.BackEnd.Repository.TagDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tag1Bean {

    /* TODO Client 화풍 선택 request_id, tag_name이 들어옴
        도건 Server에 요청, status 수정
        request_id, tag_name 반환
        status 수정 */
    @Autowired
    TagDAORepository tagDAORepository;
    @Autowired
    ImageDAORepository imageDAORepository;
    @Autowired
    UpdateStatusBean updateStatusBean;
    @Autowired
    RequestEmojiDAORepository requestEmojiDAORepository;

    public RequestUrlEmojiDTO exec(String requestId, String tagName, int setNum){
        TagDAO tagDAO = tagDAORepository.findByRequestIdAndTagNameAndSetNum(
                requestId, tagName, setNum);
        RequestUrlEmojiDTO requestUrlEmojiDTO = new RequestUrlEmojiDTO();
        if (tagDAO != null) {
            ImageDAO imageDAO = imageDAORepository.findImageDAOByRequestId(requestId);
            imageDAORepository.save(updateStatusBean.exec(imageDAO, 2));
            RequestEmojiDAO requestEmojiDAO = new RequestEmojiDAO(requestId,
                    StatusType.WAITEMOJI, tagName, setNum);
            System.out.println("RequestEmojiDAO : " + requestEmojiDAO);
            requestEmojiDAORepository.save(requestEmojiDAO);
            requestUrlEmojiDTO.setEmojiRequestId(requestEmojiDAO.getEmojiRequestId());
        }
        ImageDAO imageDAO = imageDAORepository.findImageDAOByRequestId(requestId);

        requestUrlEmojiDTO.setImgName(imageDAO.getImgName());
        requestUrlEmojiDTO.setSetNum(tagDAO.getSetNum());
        return requestUrlEmojiDTO;
    }
}
