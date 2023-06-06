package com.emojiMaker.BackEnd.Model.DAO;

import com.emojiMaker.BackEnd.Model.Enum.StatusType;

import javax.persistence.*;
import java.awt.*;

@Entity
public class ImgDAO {
    @Id @GeneratedValue
    private Long requestId;

    private String imgUrl;

    private String imgName;

    @Enumerated(EnumType.STRING)
    private StatusType status;
}
