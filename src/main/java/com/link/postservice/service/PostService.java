package com.link.postservice.service;

//import com.link.postservice.dao.PostDaoImpl;

import com.link.postservice.dao.PostDao;
import com.link.postservice.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

//    public PostService(PostDaoImpl postDao) {
//        this.postDao = postDao;
//    }
//

}