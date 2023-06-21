package com.emojiMaker.BackEnd.Model.DTO.newDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInfoDTO {

    private String userId;
    private String email;
    private String picture;
    private String nickName;

    public UserInfoDTO(String userId, String email, String picture, String nickName) {
        this.userId = userId;
        this.email = email;
        this.picture = picture;
        this.nickName = nickName;
    }
}
