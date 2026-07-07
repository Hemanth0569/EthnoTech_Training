package org.example.socialmediasystem.controller;

import org.example.socialmediasystem.entity.UserEntity;
import org.example.socialmediasystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService ser;

    @PostMapping("/register")
    public String userSignUp(@RequestBody UserEntity user)
    {
        return ser.userSignUp(user);
    }

    @PostMapping("/login")
    public UserEntity userLogin(@RequestBody UserEntity user)
    {
        return ser.userLogin(user);
    }
}
