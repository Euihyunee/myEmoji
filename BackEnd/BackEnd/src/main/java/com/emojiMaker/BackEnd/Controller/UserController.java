package com.emojiMaker.BackEnd.Controller;

import com.emojiMaker.BackEnd.Model.DAO.UserDAO;
import com.emojiMaker.BackEnd.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/info")
    public Object info(@RequestParam String userId) {
        return userService.info(userId);
    }

    @PostMapping("/history/img")
    public Object historyImg(@RequestParam String userId) {
        return userService.historyImg(userId);
    }

    @PostMapping("/history/tag")
    public Object historyTag(@RequestParam String requestId) {
        return userService.historyTag(requestId);
    }

    @PostMapping("/history/emoji")
    public Object historyEmoji(@RequestParam String requestId) {
        return userService.historyEmoji(requestId);
    }

    @PostMapping("/history/recent/request")
    public Object historyRecent(@RequestParam String userId) {
        return null;
    }
    @PostMapping("/change/nickname")
    public UserDAO changeNickname(@RequestParam String userId,
                                  @RequestParam String nickname) {
        return userService.changeNickname(userId,nickname);
    }
}
