package com.link.postservice.service;

import com.link.postservice.dao.PostDao;
import com.link.postservice.model.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    @Mock
    private PostDao postDao;

    private PostService postService;

    @BeforeEach
    void setUp() {
        postService = new PostService(postDao);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void updatePost() {
        Post testPost = new Post();

        Mockito.when(postDao.save(testPost)).thenReturn(testPost);
        postService.updatePost(testPost);

        ArgumentCaptor<Post> myCaptor = ArgumentCaptor.forClass(Post.class);

        Mockito.verify(postDao).save(myCaptor.capture());

        //Post capturedPost = myCaptor.getValue();


    }
}