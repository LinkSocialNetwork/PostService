package com.link.postservice.controller;

import com.link.postservice.dao.CommentDao;
import com.link.postservice.model.Comment;
import com.link.postservice.model.CustomResponseMessage;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200",  allowCredentials = "true")
@RequestMapping("/api/comments")
public class CommentController {

    private CommentDao commentDao;

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
    @PostMapping(value = "/createComment")
    public CustomResponseMessage createNewComment(@RequestBody Comment newComment){
        commentDao.save(newComment);
        loggy.info("Inserted a new comment into the database");
        return new CustomResponseMessage("success");
    }


    public CommentController() {
    }

    @Autowired
    public CommentController(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public CommentDao getCommentDao() {
        return commentDao;
    }


    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }
}