package org.example.socialmediasystem.controller;

import org.example.socialmediasystem.entity.ProfileEntity;
import org.example.socialmediasystem.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {

    @Autowired
    private ProfileService ser;

    @PostMapping("/saveprofile")
    public ProfileEntity saveProfile(@RequestBody ProfileEntity en)
    {
        return ser.saveProfile(en);
    }

    @GetMapping("/getProfile/{userId}")
    public ProfileEntity getProfile(@PathVariable int userId)
    {
        return ser.getProfile(userId);
    }

//    @PutMapping("/resetpass")
//    public String resetPassword(@RequestBody ProfileEntity en)
//    {
//        return ser.resetPassword(en);
//    }

    @PatchMapping("/patch")
    public String patchPass(@RequestBody ProfileEntity en)
    {
        return ser.resetPassword(en);
    }

//    @PatchMapping("/patchpass")
//    http://localhost:8081/patch?email=a@gmail.com&password=iLoveYou
//    public String patchPassword(@RequestParam String email, @RequestParam String password)
//    {
//        return ser.changePass(email,password);
//    }

}
