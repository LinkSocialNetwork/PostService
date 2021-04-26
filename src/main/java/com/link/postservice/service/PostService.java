package com.link.postservice.service;

//import com.link.postservice.dao.PostDaoImpl;

import com.link.postservice.dao.PostDao;
import com.link.postservice.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service("PostService")
public class PostService {

    PostDao postDao;

    public PostService(){}
    @Autowired
    public PostService(PostDao postDao) {
        this.postDao = postDao;
    }

    /** Author: Nick Haselden
     * Service method that simply calls on the DAO layer to grab all existing post objects.
     * @return Array list of Post objects.
     */
    public List<Post> getAllPosts(){
        return postDao.findAll();
    }

    /**
     * For pagination
     */
    public List<Post> getTwentyPosts(Integer page){
        Pageable pages = PageRequest.of(page, 3);
        Page<Post> dynamicPost = postDao.findAll(pages);
        return dynamicPost.getContent();
    }
    public List<Post> getFollowingPosts(Integer page){
        Pageable pages = PageRequest.of(page, 3);
        //TODO: Change so this makes a request instead of "new ArrayList<>(Arrays.asList(1,3))"
        ArrayList<Integer> followingUserIDs = new ArrayList<>(Arrays.asList(1,3));
        Page<Post> dynamicPost = postDao.findByUserUserIdIn(followingUserIDs, pages);
        return dynamicPost.getContent();
    }

    /** Author : Dang La
    *   Passes Post object to DAO layer to be deleted.
     * @param postId object
    * */
    public void deletePost(int postId){
         postDao.deleteById(postId);
    }

    /** Author: Sam Jenkins
     * Calls the Dao layer to retrieve posts created by a given user
     */
    public List<Post> getPostsCreatedByUser(int userId) {
        return postDao.findAllByUserUserId(userId);
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