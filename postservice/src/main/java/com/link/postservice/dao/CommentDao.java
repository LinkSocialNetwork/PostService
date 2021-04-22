package com.link.postservice.dao;

import com.link.postservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * CommentDao interface implementing CrudRepository from spring data
 * No longer do you need code but simply keywords such as .save, .delete,
 * .deleteById, .findAll, .findById, and more to spring to do transaction for you
 */
public interface CommentDao extends CrudRepository<Comment, Integer> {

//    public void insert(Comment comment);
//    public void update(Comment comment);
//    public void delete(Comment comment);
//    public Comment findByCommentId(int commentId);
//    public List<Comment> findAll();
//    public List<Comment> findByPostId(int postId);
//    public List<Comment> getAllForUser(int userId);

}
