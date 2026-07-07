package org.example.socialmediasystem.controller;

import org.example.socialmediasystem.entity.PostEntity;
import org.example.socialmediasystem.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService ser;

    @PostMapping("/addpost")
    public PostEntity savePost(@RequestBody PostEntity post)
    {
        return ser.savePost(post);
    }

    @GetMapping("/getAll")
    public List<PostEntity> getAllPosts()
    {
        return ser.getAllPosts();
    }

    @GetMapping("/getUserPost/{userId}")
    public List<PostEntity> getPosts(@PathVariable int userId)
    {
        return ser.getPost(userId);
    }

    @PutMapping("/editpost")
    public String updatePost(@RequestBody PostEntity post)
    {
        return ser.updatePost(post);
    }

    @DeleteMapping("/delete")
    public String deletePost(@RequestBody PostEntity post)
    {
        return ser.deletePost(post);
    }

//    @DeleteMapping("/delete/{id}")
//    public String deletePost(@PathVariable Long id)
//    {
//        return ser.deletePost(id);
//    }

//    @DeleteMapping("/delete")
//    public String deletePost(@RequestBody PostEntity post)
//    {
//        return ser.deletePost(post);
//    }

}
