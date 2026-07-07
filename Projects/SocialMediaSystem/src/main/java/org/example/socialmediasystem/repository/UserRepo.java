package org.example.socialmediasystem.repository;

import org.example.socialmediasystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Long> {

    UserEntity findByEmail(String email);
}
