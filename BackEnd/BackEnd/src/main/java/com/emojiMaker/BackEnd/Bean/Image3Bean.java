package com.emojiMaker.BackEnd.Bean;

import org.springframework.stereotype.Component;

@Component
public class Image3Bean {

    /* TODO 도건 Server에서 request_id, {img_url, tag_name}s 날아옴
        1. request_id로 status 조회
        2. status 수정 (enum 타입)
        3. DAO에 매핑
        4. DB에 DAO 저장
        # DAO : id, img_url, tag_name, request_id / tag 개수만큼 생김
    */
}
