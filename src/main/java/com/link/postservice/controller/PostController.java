package com.link.postservice.controller;

//import com.link.postservice.dao.PostDaoImpl;
import com.link.postservice.dao.PostDao;
import com.link.postservice.model.Comment;
import com.link.postservice.model.Post;
import com.link.postservice.service.LikeService;
import com.link.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200",  allowCredentials = "true")
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;
    private LikeService likeService;

    /** Author: Michael Loutfi
     * Api endpoint that returns an Array list of Post objects from the service layer.
     * Also, this endpoint maps the returned array list to a JSON in the HTTP response body.
     * @return Array list of all Post objects from all Users.
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


    /** Author: Sam Jenkins
     * Api endpoint that returns a list of posts from a given user.
     * @param
     */
    @GetMapping(value="/getPostsCreatedByUser/{userId}")
    public List<Post> getPostsCreatedByUser(@PathVariable("userId") int userId) {
        return postService.getPostsCreatedByUser(userId);
    }

    @GetMapping(value="/getPostById/{postId}")
    public Post getPostById(@PathVariable("postId") int id){
        return postService.getPostById(id);
    }


    /**
     * Author: Devin Kadrie
     * Api endpoint that updates a post inside the DB to have the information stored in the parameter
     * MAKE SURE TO PASS IN THE FULLY UPDATED OBJECT.
     * @param changedPost The full post object that contains all of the update information
     */
    @PutMapping(value = "/updatePost")
    public void updatePost(@RequestBody Post changedPost){
        postService.updatePost(changedPost);

    }

    /**
     * Author: So Morishima
     * Gets all posts liked by user
     * @param userId the id whom is targeted
     * @return a list of posts that the targeted user liked
     */

    @GetMapping(value="/getPostsLikedByUser/{userId}")
    public List<Post> getPostsLikedByUser(@PathVariable("userId") int userId) {


        return likeService.getPostsLikedByUser(userId);
    }


    public PostController(){}

    @Autowired
    public PostController(PostService postService, LikeService likeService) {
        this.postService = postService;
        this.likeService = likeService;
    }
}
