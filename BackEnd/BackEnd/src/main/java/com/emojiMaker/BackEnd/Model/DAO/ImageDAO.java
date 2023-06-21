package com.emojiMaker.BackEnd.Model.DAO;

import com.emojiMaker.BackEnd.Model.Enum.StatusType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
public class ImageDAO extends BaseTimeEntity {

    @Id
    private String requestId;
    private String userId;
    private int wait;
    private String imgUrl;
    private String imgName;
    @Enumerated(EnumType.STRING)
    private StatusType status;

    public ImageDAO(String requestId,
                    String userId,
                    String imgUrl,
                    String imgName,
                    StatusType status){
        this.requestId = requestId;
        this.userId = userId;
        this.imgUrl = imgUrl;
        this.imgName = imgName;
        this.status = status;
        this.wait = 0;
    }

}
