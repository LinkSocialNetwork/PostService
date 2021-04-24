package com.link.postservice.dao;

import com.link.postservice.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LikeService extends JpaRepository<Like, Integer> {
    //    public void insert(Like like);
//    public void update(Like like);
//    public void delete(Like like);
//    public Like findById(int LikeId);
//    public List<Like> findAll();
    public List<Like> findAllByPostPostId(int postId);
    public List<Like> findAllByUserId(int userId);
}
