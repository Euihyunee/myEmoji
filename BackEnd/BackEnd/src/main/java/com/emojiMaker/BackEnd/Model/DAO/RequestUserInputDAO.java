package com.emojiMaker.BackEnd.Model.DAO;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class RequestUserInputDAO {
    private Long requestId;
    private String userInputUrl; // userinput 저장한 cdn 주소
    private Date date;

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    @Id
    public Long getRequestId() {
        return requestId;
    }
}
