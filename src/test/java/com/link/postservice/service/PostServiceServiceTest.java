package com.link.postservice.service;

import com.link.postservice.dao.PostDao;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

public class PostServiceServiceTest {

    @Mock
    private PostDao postDao;


    private PostService postService;


    @BeforeEach
    void setUp(){
        this.postService = new PostService(postDao);
    }
}
