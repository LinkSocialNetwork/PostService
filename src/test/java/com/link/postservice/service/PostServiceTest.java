package com.link.postservice.service;


import com.link.postservice.dao.PostDao;
import com.link.postservice.model.Comment;
import com.link.postservice.model.Like;
import com.link.postservice.model.Post;
import com.link.postservice.model.User;
import com.link.postservice.service.PostService;
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
public class PostServiceTest {

    @Mock
    private PostDao postDao;

    private PostService postService;
    private LikeService likeService;
    @BeforeEach
    void setUp() {
        postService = new PostService(postDao);

    }
    @Test
    void deletePost() {
        List<Comment> comments = new ArrayList<>();
        List<Like> usersWhoLiked = new ArrayList<>();
        User aUser = new User();
        User aUser2 = new User();
        Post myPost = new Post(1,aUser,"some post content","a post image link","a youtube link", "a posted time", usersWhoLiked, comments);
        Post aNullPost = null;
        postService.deletePost(myPost.getPostId());
        Mockito.verify(postDao).deleteById(myPost.getPostId());
        myPost = postService.getPostById(myPost.getPostId());
        assertEquals(aNullPost, myPost);

    }


}
