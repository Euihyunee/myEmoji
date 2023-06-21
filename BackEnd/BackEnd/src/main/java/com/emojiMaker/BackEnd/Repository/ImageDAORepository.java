package com.emojiMaker.BackEnd.Repository;

import com.emojiMaker.BackEnd.Model.DAO.ImageDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDAORepository extends JpaRepository<ImageDAO, String> {
    ImageDAO findImageDAOByRequestId(String requestId);
}
