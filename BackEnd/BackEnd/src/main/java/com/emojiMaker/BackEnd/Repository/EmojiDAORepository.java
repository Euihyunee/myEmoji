package com.emojiMaker.BackEnd.Repository;

import com.emojiMaker.BackEnd.Model.DAO.EmojiDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmojiDAORepository extends JpaRepository<EmojiDAO, Long> {

    List<EmojiDAO> findAllByRequestId(String requestId);

}
