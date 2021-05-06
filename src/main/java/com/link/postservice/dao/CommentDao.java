package com.link.postservice.dao;

import com.link.postservice.model.Comment;
import org.springframework.data.repository.CrudRepository;


/**
 * CommentDao interface implementing CrudRepository from spring data
 * No longer do you need code but simply keywords such as .save, .delete,
 * .deleteById, .findAll, .findById, and more to spring to do transaction for you
 */
public interface CommentDao extends CrudRepository<Comment, Integer> {

}
