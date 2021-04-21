package com.link.postservice.service;

import com.link.postservice.dao.PostDaoImpl;


public class PostService {

    PostDaoImpl postDao;

    public PostService(){
    }

    public PostService(PostDaoImpl postDao) {
        this.postDao = postDao;
    }

}
