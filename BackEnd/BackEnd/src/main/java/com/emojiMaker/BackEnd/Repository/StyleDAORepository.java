package com.emojiMaker.BackEnd.Repository;

import com.emojiMaker.BackEnd.Model.DAO.StyleDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StyleDAORepository extends JpaRepository<StyleDAO, Long> {
    List<StyleDAO> findAllByRequestId(String requestId);
}
