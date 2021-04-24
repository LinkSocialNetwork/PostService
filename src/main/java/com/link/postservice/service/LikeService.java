package com.link.postservice.service;

import com.link.postservice.model.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
