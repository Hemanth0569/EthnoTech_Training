package org.example.poolmate.Repository;

import org.example.poolmate.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Long> {
    UserEntity findByEmail(String email);
}
