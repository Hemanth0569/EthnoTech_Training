package org.example.socialmediasystem.repository;

import org.example.socialmediasystem.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepo extends JpaRepository<PostEntity,Long> {

    public List<PostEntity> findByUserId(int userId);
}
