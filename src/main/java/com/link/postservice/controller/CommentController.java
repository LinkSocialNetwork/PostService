package com.link.postservice.controller;

import com.link.postservice.model.Comment;
import com.link.postservice.model.CustomResponseMessage;
import com.link.postservice.model.Notification;
import com.link.postservice.service.CommentService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/postservice")
public class CommentController {

    private CommentService commentService;
    private RestTemplate restTemplate = null;

    final static Logger loggy = Logger.getLogger(CommentController.class);

    static {
        loggy.setLevel(Level.ALL);
    }

    /**
     * Takes in a new comment and inserts into comment table in database
     * @param newComment
     * @return
     */
    @PostMapping(value = "/protected/comment")
    public CustomResponseMessage createNewComment(@RequestBody Comment newComment){
        Notification n = new Notification();
        n.setTriggeredId(newComment.getCommentWriter().getUserID());
        n.setTargetId(newComment.getCommentPost().getUser().getUserID());
        n.setType("comment");
        n.setPostId(newComment.getCommentPost().getPostId());
        try{

            if(this.restTemplate == null)
                this.restTemplate = new RestTemplate();

            boolean b = this.restTemplate.postForObject("http://localhost:9080/api/notificationservice", n, Boolean.class);
            if(!b) return new CustomResponseMessage("Notification service down");
        }catch(Exception e){
            e.printStackTrace();
        }
        try {
            commentService.addComment(newComment);
            return new CustomResponseMessage("success");
        }catch(ArrayIndexOutOfBoundsException e) {
            loggy.info("Error has occurred when creating a comment: " + e);
            return new CustomResponseMessage("an error has occurred");
        }
    }


    public CommentController() {
    }

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

}