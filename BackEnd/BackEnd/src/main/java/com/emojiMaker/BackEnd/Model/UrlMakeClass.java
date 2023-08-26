package com.emojiMaker.BackEnd.Model;

import lombok.Data;

@Data
public class UrlMakeClass {

    private String myUrl;
    private String AiUrl;

    public UrlMakeClass() {
        this.myUrl = "http://3.34.178.125:8080/";
//        this.myUrl = "http://localhost:8080/";
        this.AiUrl = "http://219.250.128.100:8000/";
    }
}
