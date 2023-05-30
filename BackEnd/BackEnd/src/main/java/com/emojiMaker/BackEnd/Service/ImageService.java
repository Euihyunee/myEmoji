package com.emojiMaker.BackEnd.Service;

import com.emojiMaker.BackEnd.Bean.Image1Bean;
import com.emojiMaker.BackEnd.Model.DTO.Image.ImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    Image1Bean image1Bean;

    public ImageDTO uploadImg(MultipartFile imgFile) throws IOException {
        ImageDTO imageDTO = image1Bean.exec(imgFile);
        return imageDTO;
    }
}
