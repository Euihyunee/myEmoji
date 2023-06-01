package com.emojiMaker.BackEnd.Repository;

import com.emojiMaker.BackEnd.Model.DAO.EmojiDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmojiDAORepository extends JpaRepository<EmojiDAO, Long> {

}
