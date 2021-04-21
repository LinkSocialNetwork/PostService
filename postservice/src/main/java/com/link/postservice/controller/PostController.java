package com.link.postservice.controller;

import com.link.postservice.dao.PostDaoImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {

    private PostDaoImpl postDao;


    /*
    @GetMapping(value="/all-posts")
    public List<Post> getAllPosts(){
        List<Post> postList = postDao.getAllPosts();
        return postList;
    }
*/

}
