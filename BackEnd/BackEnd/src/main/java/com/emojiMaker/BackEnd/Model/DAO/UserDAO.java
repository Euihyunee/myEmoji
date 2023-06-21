package com.emojiMaker.BackEnd.Model.DAO;

import com.emojiMaker.BackEnd.Model.DAO.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class UserDAO extends BaseTimeEntity {

    @Id
    private String userId;
    private String email;
    private String picture;
    private String accessToken;
    @Setter
    private String nickName;

    public UserDAO(String userId, String email, String picture, String accessToken) {
        this.userId = userId;
        this.email = email;
        this.picture = picture;
        this.accessToken = accessToken;
        this.nickName = String.valueOf(userId);
    }

    public UserDAO() {

    }
}
