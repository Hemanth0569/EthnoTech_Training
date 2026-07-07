package org.example.socialmediasystem.repository;

import org.example.socialmediasystem.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<ProfileEntity,Long> {

    public ProfileEntity findByUserId(int userId);
    public ProfileEntity findByEmail(String email);
}
