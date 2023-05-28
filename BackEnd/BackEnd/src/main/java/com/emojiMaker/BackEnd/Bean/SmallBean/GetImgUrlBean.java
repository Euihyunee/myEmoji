package com.emojiMaker.BackEnd.Bean.SmallBean;

import org.springframework.stereotype.Component;

@Component
public class GetImgUrlBean {

    // TODO img_url 생성하는 빈. CND 저장 url 가져오는 거임(어떻게 할까?)
    public String exec(String imgName){

        String imgUrl = "http://localhost:8080/img/input/" + imgName;

        return imgUrl;
    }
}
