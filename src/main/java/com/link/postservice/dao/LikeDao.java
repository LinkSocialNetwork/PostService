package com.link.postservice.dao;

import com.link.postservice.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LikeDao extends JpaRepository<Like, Integer> {

    public List<Like> findAllByPostPostId(int postId);
    public List<Like> findAllByUserUserID(int userId);
    public Like findById(int likeID);
}
