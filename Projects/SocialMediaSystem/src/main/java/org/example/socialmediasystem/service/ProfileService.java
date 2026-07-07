package org.example.socialmediasystem.service;

import org.example.socialmediasystem.entity.ProfileEntity;
import org.example.socialmediasystem.entity.UserEntity;
import org.example.socialmediasystem.repository.ProfileRepo;
import org.example.socialmediasystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepo repo;

    @Autowired
    private UserRepo userRepo;
    public ProfileEntity saveProfile(ProfileEntity en)
    {
        return repo.save(en);
    }

    public ProfileEntity getProfile(int userId)
    {
        return repo.findByUserId(userId);
    }

    public String resetPassword(ProfileEntity en)
    {
        UserEntity existing = userRepo.findByEmail(en.getEmail());
        if(existing==null)
        {
            return "User not found";
        }
        existing.setPassword(en.getPassword());
        existing.setConfirmPassword(en.getPassword());
        userRepo.save(existing);
        return "Successfully updated password";
    }

//    public String changePass(String email, String pass)
//    {
//        UserEntity existing = userRepo.findByEmail(email);
//        if(existing==null)
//        {
//            return "User not found";
//        }
//        existing.setPassword(pass);
//        existing.setConfirmPassword(pass);
//        userRepo.save(existing);
//        return "Successfully updated password";
//    }

}
