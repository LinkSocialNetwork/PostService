package com.link.postservice.controller;

//import com.link.postservice.dao.PostDaoImpl;
import com.link.postservice.dao.PostDao;
import com.link.postservice.model.Comment;
import com.link.postservice.model.Post;
import com.link.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200",  allowCredentials = "true")
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    /**
     * Api endpoint that returns an Array list of Post objects from the service layer.
     * @return Array list of all Post objects from all Users in the HTTP response body.
     */
    @GetMapping(value="/getAllPosts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping(value="/newposts")
    public void insertPost(@RequestBody Post post){
        postService.save(post);
    }


    /** Author: Dang La
     * Api endpoint that deletes a Post by passing its information to the appropriate method in the SERVICE layer
     * @param postToBeDeleted The Post object to be deleted
     *
     */
    @PostMapping(value="/deletePost")
    public void deletePost (Post postToBeDeleted){
        postService.deletePost(postToBeDeleted);
    }

    @GetMapping(value="/getPostById/{postId}")
    public Post getPostById(@PathVariable("postId") int id){
        return postService.getPostById(id);
    }





    public PostController(){}

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


}
