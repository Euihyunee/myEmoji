package com.emojiMaker.BackEnd.Model.DAO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmojiDAO {

    @Id
    @GeneratedValue
    private Long id;
    private String requestId;
    private String tagName;
    private String emojiUrl;
    private String emojiTag;


    public EmojiDAO() {}
    public EmojiDAO(String requestId, String tagName, String emojiUrl, String emojiTag) {
        this.requestId = requestId;
        this.tagName = tagName;
        this.emojiUrl = emojiUrl;
        this.emojiTag = emojiTag;
    }
}
