package com.link.postservice.service;

import com.link.postservice.dao.CommentDao;
import com.link.postservice.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("commentService")
public class CommentService {
    private CommentDao commentDao;

    @Autowired
    public CommentService(CommentDao commentDao){
        this.commentDao = commentDao;
    }



    public void addComment(Comment newComment) {
        this.commentDao.save(newComment);
    }



}
