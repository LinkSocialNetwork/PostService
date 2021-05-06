package com.link.postservice.controller;

import com.link.postservice.model.Comment;
import com.link.postservice.model.CustomResponseMessage;
import com.link.postservice.service.CommentService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/postservice")
public class CommentController {

    private CommentService commentService;

    final static Logger loggy = Logger.getLogger(CommentController.class);

    static {
        loggy.setLevel(Level.ALL);
    }

    /**
     * Takes in a new comment and inserts into comment table in database
     * @param newComment
     * @return
     */
    @PostMapping(value = "/comment")
    public CustomResponseMessage createNewComment(@RequestBody Comment newComment){
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