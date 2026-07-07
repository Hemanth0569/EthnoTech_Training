package org.example.socialmediasystem.service;

import org.example.socialmediasystem.entity.PostEntity;
import org.example.socialmediasystem.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepo repo;

    public PostEntity savePost(PostEntity post)
    {
        return repo.save(post);
    }

    public List<PostEntity> getAllPosts(){
        return repo.findAll();
    }

    public List<PostEntity> getPost(int userId)
    {
        return repo.findByUserId(userId);
    }

    public String updatePost(PostEntity post)
    {
        PostEntity existing = repo.findById(post.getId()).orElse(null);
        existing.setTitle(post.getTitle());
        existing.setDescription(post.getDescription());
        existing.setPostImage(post.getPostImage());
        repo.save(existing);
        return "Successfully edited";
    }

    public String deletePost(PostEntity post)
    {
        repo.deleteById(post.getId());
        return "Post deleted Successfully";
    }

//    public String deletePost(Long id)
//    {
//        repo.deleteById(id);
//        return "Post deleted Successfully";
//    }

//    public String deletePost(PostEntity post)
//    {
//        repo.delete(post);
//        return "Post deleted Successfully";
//    }

}
