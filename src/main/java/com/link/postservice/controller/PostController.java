package com.link.postservice.controller;

//import com.link.postservice.dao.PostDaoImpl;
import com.link.postservice.dao.PostDao;
import com.link.postservice.model.Comment;
import com.link.postservice.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostDao postDao;



    @GetMapping(value="/all-posts")
    public List<Post> getAllPosts(){
        List<Post> postList = postDao.findAll();
        return postList;
    }

    @PostMapping(value="/newposts")
    public void insertPost(@RequestBody Post post){
        postDao.save(post);
    }

    @Autowired
    public PostController(PostDao postDao) {
        this.postDao = postDao;
    }
}
