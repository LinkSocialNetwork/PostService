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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PostControllerTest {

    PostController postCont;

    @Mock
    PostService postServ;
    @Mock
    LikeService likeServ;

    @BeforeEach
    void setUp() {
        postCont = new PostController(postServ, likeServ);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPostById() {
        User myUser = new User();
        List<Like> likeList = new ArrayList<>();
        List<Comment> comsList = new ArrayList<>();
        Post myPost = new Post(1, myUser, "test", "test", "test", "test", likeList, comsList);

        Mockito.when(postServ.getPostById(myPost.getPostId())).thenReturn(myPost);

        Post testPost = postCont.getPostById(1);

        Mockito.verify(postServ).getPostById(1);

        assertEquals(myPost, testPost);

    }
}