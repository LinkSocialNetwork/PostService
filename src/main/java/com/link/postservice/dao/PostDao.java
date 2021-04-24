package com.link.postservice.dao;

import com.link.postservice.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDao extends JpaRepository<Post, Integer> {

    /** Authored by Sam Jenkins
     *
     */

    List<Post> findAllByUserId(int userId);
}
