package com.link.postservice.controller;


import com.link.postservice.model.Comment;
import com.link.postservice.model.Like;
import com.link.postservice.model.Post;
import com.link.postservice.model.User;
import com.link.postservice.service.LikeService;
import com.link.postservice.service.PostService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PostControllerTest {

    PostController postController;

    @Mock
    PostService postService;

    @Mock
    LikeService likeService;

    @BeforeEach
    void setUp(){
        postController = new PostController(postService, likeService);
    }

    @AfterEach
    void tearDown(){}

    @Test
    void insertPost(){
        User user = new User();
        List<Like> likes = new ArrayList<Like>();
        List<Comment> comments= new ArrayList<Comment>();
        Post post = new Post(
                1,
                user,
                "test body",
                "test img url",
                "test youtube url",
                "test time",
                likes,
                comments
        );

        postController.insertPost(post);
        Mockito.verify(postService).save(post);
    }

    @Test
    void updatePost() {
        Post post = new Post();

        postController.updatePost(post);

        Mockito.verify(postService).updatePost(post);

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

        Mockito.when(postService.getPostsCreatedByUser(u.getUserId())).thenReturn(postList);

        List<Post> actualReturn = postController.getPostsCreatedByUser(u.getUserId());

        Mockito.verify(postService).getPostsCreatedByUser(u.getUserId());

        assertEquals(postList, actualReturn);
    }

}