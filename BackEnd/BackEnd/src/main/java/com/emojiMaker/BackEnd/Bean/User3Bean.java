package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Model.DAO.TagDAO;
import com.emojiMaker.BackEnd.Repository.TagDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class User3Bean {

    @Autowired
    TagDAORepository tagDAORepository;

    public Object exec(String requestId) {
        List<TagDAO> tagDAOList = tagDAORepository.findAllByRequestId(requestId);
        return tagDAOList;
    }
}
