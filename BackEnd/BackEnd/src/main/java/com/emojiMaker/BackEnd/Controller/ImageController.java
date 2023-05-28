package com.emojiMaker.BackEnd.Controller;

import com.emojiMaker.BackEnd.Model.DTO.Image.User;
import com.emojiMaker.BackEnd.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Controller
@RequestMapping("/img")
@CrossOrigin("*")
public class ImageController {

    @Autowired
    private UserRepository repo;
    // TODO img 들어옴
    @PostMapping("/uploadImg")
    public User imgData(User user, @RequestParam("file") MultipartFile file) throws IOException {
        // TODO Img Upload Test용
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        user.setPhotos(fileName);
        User savedUser = repo.save(user);

        String uploadDir = "user-photos/" + savedUser.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, file);

        return user;
    }

    // TODO status 수정(도건Server에서 요청 들어옴)
    @PostMapping("/postMethod")
    public void completeRequest(@RequestBody String status){

    }

    // TODO 결과 조회
    @GetMapping("/status/{requestId}")
    public String getStatus(@PathVariable String requestId){

        return requestId;
    }
}
