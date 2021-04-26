package com.link.postservice.service;

import com.link.postservice.dao.PostDao;
import com.link.postservice.model.Post;
import com.link.postservice.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    private PostService postServ;

    @Mock
    private PostDao postDao;

    @BeforeEach
    void setUp() {
        postServ = new PostService(postDao);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPostsCreatedByUser() {
        User u = new User();
        u.setUserId(1);

        List<Post> postList = new ArrayList<>();

        Post p1 = new Post();
        p1.setPostContent("Hello I am new to this site");
        p1.setPostId(1);
        p1.setUser(u);

        Post p2 = new Post();
        p2.setPostContent("Hello again");
        p2.setPostId(2);
        p2.setUser(u);

        postList.add(p1);
        postList.add(p2);

        Mockito.when(postDao.findAllByUserUserId(u.getUserId())).thenReturn(postList);

        List<Post> actualReturn = postServ.getPostsCreatedByUser(u.getUserId());

        Mockito.verify(postDao).findAllByUserUserId(u.getUserId());

        assertEquals(postList, actualReturn);
    }
}