package com.emojiMaker.BackEnd.Model.DTO.Image;

import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.awt.*;

@Entity
@Getter
public class ImageDTO {

    @Id
    private String requestId;
    private String imgUrl;
    private byte[] img;
    private long userId;
    @Enumerated(EnumType.STRING)
    private StatusType status;

    public ImageDTO(String requestId, String imgUrl, StatusType status){
        this.requestId = requestId;
        this.imgUrl = imgUrl;
        this.status = status;
    }

    public ImageDTO() {

    }
}
