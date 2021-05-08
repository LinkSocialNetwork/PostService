package com.link.postservice.controller;

import com.link.postservice.model.CustomResponseMessage;
import com.link.postservice.model.Like;
import com.link.postservice.model.Notification;
import com.link.postservice.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/postservice")
public class LikeController {

    private LikeService likeService;
    private RestTemplate restTemplate = null;


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

    public void setRestTemplate(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    /**
     * retrieves an List of all Like object from the SERVICE layer
     * @return An ArrayList of Like objects
     */
    @GetMapping(value = "/like")
    public List<Like> getAllLikes(){
        return likeService.findAll();
    }


    /**
     * Deletes a Like object by passing its information to the appropriate method
     * in the SERVICE layer
     * @param likeId the Like object to be deleted from the database
     * @return A String containing a confirmation message
     */
    @DeleteMapping(value = "/protected/like/{likeId}")
    public CustomResponseMessage deleteLike(@PathVariable("likeId") int likeId){
        likeService.delete(likeId);
        return new CustomResponseMessage("Like was deleted.");
    }

    /**
     * Inserts a new Like into the database by passing it to the SERVICE layer
     * @param like the new Like object to be inserted to the database
     * @return a confirmation message that the Like was inserted
     */
    @PostMapping(value = "/protected/post/like")
    public CustomResponseMessage insertNewLike( @RequestBody Like like){
        Notification n = new Notification();
        n.setTriggeredId(like.getUser().getUserID());
        n.setTargetId(like.getPost().getUser().getUserID());
        n.setType("like");
        n.setPostId(like.getPost().getPostId());
        try{

            if(this.restTemplate == null)
                this.restTemplate = new RestTemplate();

            boolean b = this.restTemplate.postForObject("http://localhost:9080/api/notificationservice", n, Boolean.class);
            if(!b) return new CustomResponseMessage("Notification service down");
        }catch(Exception e){
            e.printStackTrace();
        }

        likeService.save(like);
        return new CustomResponseMessage("Like was added.");
    }

}
