package com.emojiMaker.BackEnd.Model.DAO;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class TagDAO {

    @Id @GeneratedValue
    private long id;
    private String requestId;
    private String tagName;
    private String tagUrl;
    private int setNum;
    public TagDAO(String requestId, String tagName, String tagUrl, int setNum) {
        this.requestId = requestId;
        this.tagName = tagName;
        this.tagUrl = tagUrl;
        this.setNum = setNum;
    }
    public TagDAO() {

    }
}
