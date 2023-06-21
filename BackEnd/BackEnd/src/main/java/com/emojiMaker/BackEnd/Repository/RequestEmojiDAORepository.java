package com.emojiMaker.BackEnd.Repository;

import com.emojiMaker.BackEnd.Model.DAO.RequestEmojiDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestEmojiDAORepository extends JpaRepository<RequestEmojiDAO, String> {

    RequestEmojiDAO findByEmojiRequestId(String emojiRequestId);
    RequestEmojiDAO findByRequestId(String requestId);

    List<RequestEmojiDAO> findAllByUserId(String userId);
}
