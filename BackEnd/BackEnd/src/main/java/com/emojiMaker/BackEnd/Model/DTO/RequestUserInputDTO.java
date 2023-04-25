package com.emojiMaker.BackEnd.Model.DTO;

import com.emojiMaker.BackEnd.Model.Enum.RequestType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserInputDTO {
    @Nullable
    private String requestId;
    RequestType requestType;
    String imgUrl;

}
