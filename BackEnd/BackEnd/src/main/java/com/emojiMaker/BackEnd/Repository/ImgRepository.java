package com.emojiMaker.BackEnd.Repository;

import com.emojiMaker.BackEnd.Model.DAO.ImgDAO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImgRepository extends JpaRepository<ImgDAO, Long> {

    StatusType findByRequestId(Long requestId);
}
