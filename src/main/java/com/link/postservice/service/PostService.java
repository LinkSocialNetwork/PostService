package com.link.postservice.service;

//import com.link.postservice.dao.PostDaoImpl;

import com.link.postservice.dao.PostDao;
import com.link.postservice.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("PostService")
public class PostService {

    PostDao postDao;

    @Autowired
    public PostService(PostDao postDao) {
        this.postDao = postDao;
    }

    public List<Post> getAllPosts(){
        return postDao.findAll();
    }

    /** Author : Dang La
    *   Passes Post object to DAO layer to be deleted.
     * @param postToBeDeleted object
    * */
    public void deletePost(Post postToBeDeleted){
         postDao.delete(postToBeDeleted);
    }

    /** Author: Sam Jenkins
     * Calls the Dao layer to retrieve posts created by a given user
     */
    public List<Post> getPostsCreatedByUser(int userId) {
        return postDao.findAllByUserId(userId);
    }

//    public PostService(PostDaoImpl postDao) {
//        this.postDao = postDao;
//    }
//
    public Post getPostById(int id){
        return postDao.findById(id);
    }
    public void save(Post post){
        postDao.save(post);
    }

    public void updatePost(Post post){
        postDao.save(post);
    }
}