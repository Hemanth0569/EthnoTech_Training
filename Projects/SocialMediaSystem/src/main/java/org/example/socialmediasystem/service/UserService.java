package org.example.socialmediasystem.service;

import org.example.socialmediasystem.entity.UserEntity;
import org.example.socialmediasystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public String userSignUp(UserEntity user)
    {
//        repo.save(user);
        UserEntity existing = repo.findByEmail(user.getEmail());
        if(existing == null && user.getPassword().equals(user.getConfirmPassword()))
        {
            repo.save(user);
            return "User sign Up was Successful";
        }
        return "User Already Exists";
    }

    public UserEntity userLogin(UserEntity user)
    {
        UserEntity existing = repo.findByEmail(user.getEmail());
        if(existing != null && user.getPassword().equals(existing.getConfirmPassword())){
            return existing;
        }
        return null;
    }

}
