package com.emojiMaker.BackEnd.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
@CrossOrigin("*")
public class RequestController{

    @GetMapping("/stp")
    public String GetStp(){return "stp";}

    @GetMapping("/ptp")
    public String GetPtp(){return "ptp";}

    @GetMapping("/withtype")
    public String GetWithtype(){return "withtype";}
}