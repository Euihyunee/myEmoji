package com.emojiMaker.BackEnd.Repository;

import com.emojiMaker.BackEnd.Model.DAO.RequestEmojiDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestEmojiDAORepository extends JpaRepository<RequestEmojiDAO, String> {

    RequestEmojiDAO findByEmojiRequestId(String emojiRequestId);
}
