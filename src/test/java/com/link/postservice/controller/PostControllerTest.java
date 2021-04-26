package com.link.postservice.controller;

import com.link.postservice.model.Post;
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

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PostControllerTest {

    @Mock
    private PostService postService;

    @Mock
    private LikeService likeService;

    private PostController postController;

    @BeforeEach
    void setUp() {
        postController = new PostController(postService, likeService);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void updatePost() {
        Post post = new Post();

        postController.updatePost(post);

        Mockito.verify(postService).updatePost(post);

    }
}