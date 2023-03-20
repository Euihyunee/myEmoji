package com.emojiMaker.BackEnd.Model.DAO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RequestUserInputWithTypeDAO {
    private Long id; // 자동생성
    private Long requestId;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
