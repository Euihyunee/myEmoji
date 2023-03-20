package com.emojiMaker.BackEnd.Controller;

import com.emojiMaker.BackEnd.Model.DAO.RandomJson;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/result")
@CrossOrigin("*")
public class ResultController{

    @GetMapping("/")
    public String GetResult(){return "result";}

    @GetMapping("/list")
    public Object GetResultList(){
        RandomJson randomJson = new RandomJson();
        randomJson.id = 1;
        randomJson.url = "Sample.com";
        return randomJson;
    }

    @GetMapping("/qr/{id}")
    public String GetResultByQR(@PathVariable int id){return id + " 결과";}
}