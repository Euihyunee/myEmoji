package com.emojiMaker.BackEnd.Service;

import com.emojiMaker.BackEnd.Bean.*;
import com.emojiMaker.BackEnd.Model.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    User1Bean user1Bean;
    @Autowired
    User2Bean user2Bean;
    @Autowired
    User3Bean user3Bean;
    @Autowired
    User4Bean user4Bean;
    @Autowired
    User5Bean user5Bean;
    @Autowired
    historyUserBean historyUserBean;

    public Object info(String userId) {
        return user1Bean.exec(userId);
    }

    public Object historyImg(String userId) {
        return user2Bean.exec(userId);
    }

    public Object historyTag(String requestId) {
        return user3Bean.exec(requestId);
    }
    public Object historyEmoji(String requestId) {
        return user4Bean.exec(requestId);
    }

    public UserDAO changeNickname(String userId, String nickname){
        return user5Bean.exec(userId, nickname);
    }

    public List<String> historyUser(String userId) {
        return historyUserBean.exec(userId);
    }
}
