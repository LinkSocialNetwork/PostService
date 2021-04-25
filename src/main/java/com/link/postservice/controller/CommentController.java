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
        //loggy.setLevel(Level.ERROR);
    }

    /**
     * Takes in a new comment and inserts into comment table in database
     * @param newComment
     * @return
     */
    @PostMapping(value = "/comment")
    public CustomResponseMessage createNewComment(@RequestBody Comment newComment){
        commentService.addComment(newComment);
        loggy.info("Inserted a new comment into the database");
        return new CustomResponseMessage("success");
    }


    public CommentController() {
    }

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

}