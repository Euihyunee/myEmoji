package com.emojiMaker.BackEnd.Model.DAO;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class StyleDAO {

    @Id @GeneratedValue
    private long id;
    private String imgUrl;
    private String tagName;
    private String requestId;


    public StyleDAO(String imgUrl, String tagName, String requestId) {
        this.imgUrl = imgUrl;
        this.tagName = tagName;
        this.requestId = requestId;
    }
    public StyleDAO() {

    }
}
