package com.emojiMaker.BackEnd.Repository;

import com.emojiMaker.BackEnd.Model.DAO.TagDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagDAORepository extends JpaRepository<TagDAO, Long> {
    List<TagDAO> findAllByRequestId(String requestId);
    TagDAO findByRequestIdAndTagNameAndSetNum(String requestId, String tagName, int setNum);

}
