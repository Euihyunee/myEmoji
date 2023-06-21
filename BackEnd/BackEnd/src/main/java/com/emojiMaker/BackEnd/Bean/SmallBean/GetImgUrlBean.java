package com.emojiMaker.BackEnd.Bean.SmallBean;

import com.emojiMaker.BackEnd.Model.UrlMakeClass;
import org.springframework.stereotype.Component;

@Component
public class GetImgUrlBean {

    UrlMakeClass urlMakeClass = new UrlMakeClass();
    // TODO img_url 생성하는 빈. CND 저장 url 가져오는 거임(어떻게 할까?)
    public String exec(String imgName){

        String imgUrl = urlMakeClass.getMyUrl() +"imagePath/"+ imgName;

        return imgUrl;
    }
}
