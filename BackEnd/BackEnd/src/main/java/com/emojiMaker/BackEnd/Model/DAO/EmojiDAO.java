package com.emojiMaker.BackEnd.Model.DAO;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class EmojiDAO {

    @Id
    @GeneratedValue
    private Long id;
    private String emojiRequestId;
    private String requestId;
    private String tagName;
    private String emojiUrl;
    private String emojiTag;
    private int setNum;


    public EmojiDAO() {}
    public EmojiDAO(String emojiRequestId,
                    String requestId, String tagName, String emojiUrl, String emojiTag, int setNum) {
        this.emojiRequestId = emojiRequestId;
        this.requestId = requestId;
        this.tagName = tagName;
        this.emojiUrl = emojiUrl;
        this.emojiTag = emojiTag;
        this.setNum = setNum;
    }
}
