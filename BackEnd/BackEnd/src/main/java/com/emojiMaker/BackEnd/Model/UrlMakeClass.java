package com.emojiMaker.BackEnd.Model;

import lombok.Data;

@Data
public class UrlMakeClass {

    private String myUrl;
    private String AiUrl;

    public UrlMakeClass() {
        this.myUrl = "http://3.39.22.13:8080/";
        this.AiUrl = "http://13.114.204.13:8000/";
    }
}
