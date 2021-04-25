package com.link.postservice.service;

import com.link.postservice.model.Like;
import com.link.postservice.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("LikeService")
public class LikeService {
    com.link.postservice.dao.LikeService likeDao;

    @Autowired
    public LikeService(com.link.postservice.dao.LikeService likeDao) {
        this.likeDao = likeDao;
    }

    public com.link.postservice.dao.LikeService getLikeDao() {
        return likeDao;
    }

    public void setLikeDao(com.link.postservice.dao.LikeService likeDao) {
        this.likeDao = likeDao;
    }


    /** @author Suliman Sam
     * Returns a List of likes chosen by post ID
     * @param postID target a specific post
     * @return the likes List
     */
    public List<Like> getAllLikesByPostID(int postID){
        return likeDao.findAllByPostPostId(postID);
    }

    /** Author: So Morishima
     *
     * Gets all posts liked by the user, referenced in the PostController
     * @param userId the targeted user
     * @return List of Posts the user liked
     */
    public List<Post> getPostsLikedByUser(int userId) {
        List<Like> likes = likeDao.findAllByUserId(userId);
        List<Post> posts = new ArrayList<>();
        for (Like l : likes) {
            posts.add(l.getPost());
        }
        return posts;
    }
}
