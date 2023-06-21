package com.emojiMaker.BackEnd.Repository;

import com.emojiMaker.BackEnd.Model.DAO.ImageDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageDAORepository extends JpaRepository<ImageDAO, String> {
    ImageDAO findImageDAOByRequestId(String requestId);
    ImageDAO findFirstByUserIdOrderByCreatedDateDesc(String userId);
    ImageDAO findByImgName(String imgName);

    List<ImageDAO> findAllByUserId(String userId);

}
