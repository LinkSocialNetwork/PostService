package com.link.postservice.dao;

import com.link.postservice.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDao extends JpaRepository<Post, Integer> {


}
