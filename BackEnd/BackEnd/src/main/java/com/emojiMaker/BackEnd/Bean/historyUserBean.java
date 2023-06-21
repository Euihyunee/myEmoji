package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Model.DAO.EmojiDAO;
import com.emojiMaker.BackEnd.Model.DAO.ImageDAO;
import com.emojiMaker.BackEnd.Model.DAO.RequestEmojiDAO;
import com.emojiMaker.BackEnd.Model.DAO.TagDAO;
import com.emojiMaker.BackEnd.Repository.EmojiDAORepository;
import com.emojiMaker.BackEnd.Repository.ImageDAORepository;
import com.emojiMaker.BackEnd.Repository.RequestEmojiDAORepository;
import com.emojiMaker.BackEnd.Repository.TagDAORepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class historyUserBean {

    @Autowired
    ImageDAORepository imageDAORepository;
    @Autowired
    RequestEmojiDAORepository requestEmojiDAORepository;
    @Autowired
    EmojiDAORepository emojiDAORepository;
    @Autowired
    TagDAORepository tagDAORepository;

    public List<String> exec(String userId) {

        // TODO userId로 요청된 사진 URL 전부 가져오기
        log.info("유저의 모든 사진 URL 가져오기");
        log.info("유저 ID로 이모티콘 요청 엔티티(RequestEmojiDAO) 리스트 가져오기");
        List<RequestEmojiDAO> requestEmojiDAOS = requestEmojiDAORepository
                .findAllByUserId(userId);
        log.info("모든 사진 URL을 전달할 리스트(requestUrls) 생성");
        List<String> requestUrls = new ArrayList<>();
        String requestId = "";
        log.info("이모티콘 요청 엔티티(RequestEmojiDAO) 리스트의 모든 URL DTO에 매핑");
        for (RequestEmojiDAO requestEmojiDAO : requestEmojiDAOS) {

            String emojiRequestId = requestEmojiDAO.getEmojiRequestId();
            List<EmojiDAO> emojiDAOS = emojiDAORepository.findAllByEmojiRequestId(emojiRequestId);
            for (EmojiDAO emojiDAO : emojiDAOS) {
                requestUrls.add(emojiDAO.getEmojiUrl());
            }
            if (Objects.equals(requestId, requestEmojiDAO.getRequestId())) continue;
            requestId = requestEmojiDAO.getRequestId();
            ImageDAO imageDAO = imageDAORepository.findImageDAOByRequestId(requestId);
            List<TagDAO> tagDAOS = tagDAORepository.findAllByRequestId(requestId);

            for (TagDAO tagDAO : tagDAOS) {
                requestUrls.add(tagDAO.getTagUrl());
            }
            requestUrls.add(imageDAO.getImgUrl());
        }
        log.info("모든 URL이 담긴 리스트(requestUrls) 반환");
        return requestUrls;
    }
}
