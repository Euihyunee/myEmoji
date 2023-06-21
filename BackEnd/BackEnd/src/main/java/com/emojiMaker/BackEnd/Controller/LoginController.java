package com.emojiMaker.BackEnd.Controller;

import com.emojiMaker.BackEnd.Model.DAO.UserDAO;
import com.emojiMaker.BackEnd.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login/oauth2", produces = "application/json")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    LoginService loginService;


    @GetMapping("/code/{registrationId}")
    public ResponseEntity<String> googleLogin(@RequestParam String code, @PathVariable String registrationId) {
        UserDAO userDAO = loginService.socialLogin(code, registrationId);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Google-AccessToken-Header", userDAO.getAccessToken());

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(userDAO.getUserId());
    }
}
