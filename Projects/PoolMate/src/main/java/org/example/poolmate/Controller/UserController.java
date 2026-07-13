package org.example.poolmate.Controller;

import org.example.poolmate.Entity.UserEntity;
import org.example.poolmate.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
