package com.emojiMaker.BackEnd.Bean;

import com.emojiMaker.BackEnd.Model.DAO.UserDAO;
import com.emojiMaker.BackEnd.Model.DTO.newDTO.UserInfoDTO;
import com.emojiMaker.BackEnd.Repository.UserDAORepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class User1Bean {

    @Autowired
    UserDAORepository userDAORepository;

    public Object exec(String userId) {
        log.info("유저 ID로 유저 정보 엔티티(userDAO) 가져오기");
        UserDAO userDAO = userDAORepository.findByUserId(userId);
        log.info("유저 정보 DTO(UserInfoDTO) 생성자로 생성");
        UserInfoDTO userInfoDTO = new UserInfoDTO(
                userDAO.getUserId(),
                userDAO.getEmail(),
                userDAO.getPicture(),
                userDAO.getNickName()
        );
        log.info("유저 ID :" + userDAO.getUserId());
        log.info("이메일 :" + userDAO.getEmail());
        log.info("프로필 :" + userDAO.getPicture());
        log.info("닉네임 :" + userDAO.getNickName());

        log.info("생성된 유저 정보 DTO(UserInfoDTO) 반환");
        return userInfoDTO;
    }
}
