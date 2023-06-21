package com.emojiMaker.BackEnd.Model.DAO;

import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class ImageDAO {

    @Id
    private String requestId;
    private String imgUrl;
    private String imgName;
    @Enumerated(EnumType.STRING)
    private StatusType status;

    public ImageDAO(String requestId, String imgUrl, String imgName, StatusType status){
        this.requestId = requestId;
        this.imgUrl = imgUrl;
        this.imgName = imgName;
        this.status = status;
    }

    public ImageDAO() {

    }
}
