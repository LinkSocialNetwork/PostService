package com.link.postservice.controller;

import com.link.postservice.model.Post;
import com.link.postservice.service.LikeService;
import com.link.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postservice")
public class PostController {

    private PostService postService;
    private LikeService likeService;

    /** Author: Nick Haselden
     * Api endpoint that returns an Array list of Post objects from the service layer.
     * Also, this endpoint maps the returned array list to a JSON in the HTTP response body.
     * @return Array list of all Post objects from all Users.
     *
     * old url: /getAllPosts
     */
    @GetMapping(value="/post")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    /**
     * GetAllPosts paginated in intervals of twenty per page
     */
    @GetMapping(value="/post/page/{number}")
    public List<Post> getTwentyPosts(@PathVariable Integer number){
        return postService.getFollowingPosts(number);
    }


    /**
     * This endpoint creates a new post object in the posts table.
     * old url: /newposts
     */
    @PostMapping(value="/post")
    public void insertPost(@RequestBody Post post){
        postService.save(post);
    }


    /** Author: Dang La
     * Api endpoint that deletes a Post by passing its information to the appropriate method in the SERVICE layer
     * @param postId The Post id to be deleted
     *
     * old url: /deletePost
     */
    @DeleteMapping(value="/post/{postId}")
    public void deletePost (@PathVariable("postId") int postId){
        postService.deletePost(postId);
    }


    /** Author: Sam Jenkins
     * Api endpoint that returns a list of posts from a given user.
     * @param userId
     */
    @GetMapping(value="/post/user/{userId}")
    public List<Post> getPostsCreatedByUser(@PathVariable("userId") int userId) {
        return postService.getPostsCreatedByUser(userId);
    }

    /**
     * Api endpoint that returns gets one post given post id.
     * @param postId
     */
    @GetMapping(value="/post/{postId}")
    public Post getPostById(@PathVariable("postId") int postId){
        return postService.getPostById(postId);
    }


    /**
     * Author: Devin Kadrie
     * Api endpoint that updates a post inside the DB to have the information stored in the parameter
     * MAKE SURE TO PASS IN THE FULLY UPDATED OBJECT.
     * @param changedPost The full post object that contains all of the update information
     */
    @PutMapping(value = "/post")
    public void updatePost(@RequestBody Post changedPost){
        postService.updatePost(changedPost);
    }

    /**
     * Author: So Morishima
     * Gets all posts liked by user
     * @param userId the id whom is targeted
     * @return a list of posts that the targeted user liked
     *
     * **method might be deprecated / unneeded**
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
