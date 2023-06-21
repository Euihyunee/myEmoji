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
public class RequestEmojiDAO {

    @Id
    private String emojiRequestId;
    private String requestId;
    private int wait;
    @Enumerated(EnumType.STRING)
    private StatusType statusType;
    private String tagName;
    private int setNum;

    public RequestEmojiDAO(String requestId, StatusType statusType, String tagName, int setNum) {
        this.emojiRequestId = requestId + tagName + setNum;
        this.requestId = requestId;
        this.wait = 0;
        this.statusType = statusType;
        this.tagName = tagName;
        this.setNum = setNum;
    }



    public RequestEmojiDAO() {

    }
}
