package com.emojiMaker.BackEnd.Model.DTO.Image;

import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.awt.*;

@Entity
public class ImageDTO {

    @Id
    private String requestId;
    private String imgUrl;
    private byte[] img;
    @Enumerated(EnumType.STRING)
    private Enum<StatusType> status;
}
