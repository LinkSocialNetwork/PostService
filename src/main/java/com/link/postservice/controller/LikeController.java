package com.link.postservice.controller;

import com.link.postservice.model.CustomResponseMessage;
import com.link.postservice.model.Like;
import com.link.postservice.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postservice")
public class LikeController {

    private LikeService likeService;


    //constructor
    public LikeController() {
    }

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }


    public LikeService getLikeService() {
        return likeService;
    }

    public void setLikeService(LikeService likeService) {
        this.likeService = likeService;
    }

    /**
     * retrieves an List of all Like object from the SERVICE layer
     * @return An ArrayList of Like objects
     */
    @GetMapping(value = "/like")
    public List<Like> getAllLikes(){
//        loggy.info("Retrieving all Likes from the Service layer/database");
        return likeService.findAll();
    }


    /**
     * Deletes a Like object by passing its information to the appropriate method
     * in the SERVICE layer
     * @param likeId the Like object to be deleted from the database
     * @return A String containing a confirmation message
     */
    @DeleteMapping(value = "/like/{likeId}")
    public CustomResponseMessage deleteLike(@PathVariable("likeId") int likeId){
        likeService.delete(likeId);
//        loggy.info("Deleting a Like in the database with id: "+like.getLikeId());
        return new CustomResponseMessage("Like was deleted.");
    }

    /**
     * Inserts a new Like into the database by passing it to the SERVICE layer
     * @param like the new Like object to be inserted to the database
     * @return a confirmation message that the Like was inserted
     */
    @PostMapping(value = "/post/like")
    public CustomResponseMessage insertNewLike( @RequestBody Like like){

        /*
        * Tested by Kevin Childs on 4/24/2021 at 8:12am
        * Successfully created a like on a post reference constraint
        *
        * checks to be added:
        *   check if user id exists in user service
        *   check if user already liked post
        * */

        likeService.save(like);
        return new CustomResponseMessage("Like was added.");
    }



















/*    *//**
     * retrieves an List of all Likes of a specific post from the SERVICE layer
     * @return An ArrayList of Like objects
     *
     * deprecated
     *//*
    @GetMapping(value = "/getAllPostLikes/{postID}")
    public List<Like> getAllPostLikes(@PathVariable("postId") int postID){
//        loggy.info("Retrieving all Likes from the Service layer/database");
        return likeService.findAllByPostPostId(postID);
    }*/


/*    *//**
     * Updates a Like object that was already in the database by calling the appropriate
     * method in the SERVICE layer
     * @param like the UPDATED Like object
     * @return a String that contains a confirmation message
     *
     * deprecated
     *//*
    @PutMapping(value = "/like")
    public CustomResponseMessage updateLike(@RequestBody Like like){
        likeService.save(like);
//        loggy.info("Updating a Like in the database");
        return new CustomResponseMessage("Like was updated.");
    }*/
/*


    *//**
     * Retrieves all Like Objects associated with a particular Post object's
     * from the SERVICE layer
     * @param postId the Id number for a particular Post object
     * @return An ArrayList of Like Objects
     *
     * deprecated
     *//*
   *//* @GetMapping(value = "/getLikesForPost/{postId}")
    public List<Like> getLikesForPost(@PathVariable("postId") int postId){
//        loggy.info("Retrieving all Likes from the Service layer/database that are connected to the post with id: "+postId);
        return likeService.findAllByPostId(postId);
    }*//*

    *//**
     * Retrieves the number of Like Objects associated with a particular Post object by
     * returning the size of an ArrayList containing the Like Objects retrieved from the
     * SERVICE layer
     * @param postId the Id number for a particular Post object
     * @return An int value
     *
     *
     * deprecated
     *//*
    @GetMapping(value = "/getLikesForPostSize/{postId}")
    public int getLikeCountForPost(@PathVariable("postId") int postId){
//        loggy.info("Retrieving the number of Likes from the Service layer/in the database connected to the post with id: "+postId);
        return likeService.findAllByPostPostId(postId).size();
    }

    *//**
     * Retrieves all Like Objects associated with a particular User object
     * from the SERVICE layer
     * @param userId the Id number for a particular User object
     * @return An ArrayList of Like Objects
     *
     * **deprecated**
     *//*
    @GetMapping(value = "/getLikesGivenByUser/{userId}")
    public List<Like> getLikesByUser(@PathVariable("userId") int userId){
//        loggy.info("Retrieving all Likes from the Service layer/in the database created by the user with id: "+userId);
        return likeService.findAllByUserId(userId);
    }*/

}
