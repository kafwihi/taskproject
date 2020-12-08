
package com.taskproject.taskproject.security.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import com.taskproject.taskproject.security.exceptions.ValidationException;
import com.taskproject.taskproject.security.model.UserInfo;
import com.taskproject.taskproject.security.repository.UserInfoRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {


    final
    private UserInfoRepository userInfoRepository;

//    private HashData hashData = new HashData();

    public UserInfoController(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }


    @PostMapping("/user")
    public UserInfo create(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException {
        String username = body.get("username");
        if (userInfoRepository.existsByUsername(username)){

            throw new ValidationException("Username already existed");

        }

        String password = body.get("password");
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
//        String hashedPassword = hashData.get_SHA_512_SecurePassword(password);

String previlage = body.get("previlage");
String permission = body.get("permission");
return userInfoRepository.save(new UserInfo(username,encodedPassword,permission,previlage));


    }

    @GetMapping("/user")
    public List<UserInfo> getAllUsers(){
        return userInfoRepository.findAll();
    }
}
