package com.emojiMaker.BackEnd.Repository;

import com.emojiMaker.BackEnd.Model.DTO.RequestUserInputDTO;
import org.springframework.stereotype.Repository;

@Repository
public class RequestRepository {
    public boolean save(RequestUserInputDTO requestUserInputDTO){

        return true;
    }
}
