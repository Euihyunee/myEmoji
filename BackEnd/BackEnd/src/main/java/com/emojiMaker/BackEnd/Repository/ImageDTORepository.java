package com.emojiMaker.BackEnd.Repository;

import com.emojiMaker.BackEnd.Model.DTO.Image.ImageDTO;
import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDTORepository extends JpaRepository<ImageDTO, String> {

    StatusType findByRequestId(String requestId);
}
