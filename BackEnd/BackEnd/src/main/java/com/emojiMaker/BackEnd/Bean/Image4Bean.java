package com.emojiMaker.BackEnd.Bean;

import org.springframework.stereotype.Component;

@Component
public class Image4Bean {

    /* TODO Client가 화풍을 조회하는 시점
        Case1. status :화풍 미완성
            -> request_id로 status확인
            -> 미완성 Response
        Case2. status :화풍 완성
            -> request_id로 status확인
            -> findByRequestId 해서 화풍 list 반환
            # 화풍DAO : id, tag_name, img_url, img, request_id */


}
