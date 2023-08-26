package com.emojiMaker.BackEnd.Controller;

import com.emojiMaker.BackEnd.Model.DAO.UserDAO;
import com.emojiMaker.BackEnd.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value = "/login/oauth2", produces = "application/json")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    LoginService loginService;


    @GetMapping("/code/{registrationId}")
    public ResponseEntity<Object> googleLogin(@RequestParam String code, @PathVariable String registrationId) throws URISyntaxException {
        UserDAO userDAO = loginService.socialLogin(code, registrationId);
        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.set("Google-AccessToken-Header", userDAO.getAccessToken());
//        return ResponseEntity.ok()
//                .headers(responseHeaders)
//                .body(userDAO.getUserId());
//    }

//        URI uri = new URI("http://ec2-3-140-252-55.us-east-2.compute.amazonaws.com:5173/login/" +"?userId=" +userDAO.getUserId() +
//                "&accessToken=" + userDAO.getAccessToken());
        URI uri = new URI("http://ec2-3-143-68-242.us-east-2.compute.amazonaws.com:5173/login/" +"?userId=" +userDAO.getUserId() +
                "&accessToken=" + userDAO.getAccessToken());
        responseHeaders.setLocation(uri);
        return new ResponseEntity<>(responseHeaders, HttpStatus.SEE_OTHER);
    }

}
