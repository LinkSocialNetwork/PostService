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
class PostControllerTest {

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
        /*Assign*/
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

        /*Act*/
        Mockito.doNothing().when(postService).save(post);
        postController.insertPost(post);

        /*Assert*/
        Mockito.verify(postService, Mockito.times(1)).save(post);
    }

    @Test
    void updatePost() {
        /*Assign*/
        Post post = new Post();

        /*Act*/
        Mockito.doNothing().when(postService).updatePost(post);
        postController.updatePost(post);

        /*Assert*/
        Mockito.verify(postService, Mockito.times(1)).updatePost(post);

    }

    @Test
    void getPostsCreatedByUser() {

        /*Assign*/
        User u = new User();
        u.setUserID(1);

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

        /*Act*/
        Mockito.when(postService.getPostsCreatedByUser(u.getUserID(),1)).thenReturn(postList);
        List<Post> actualReturn = postController.getPostsCreatedByUser(u.getUserID(),1);
        Mockito.verify(postService).getPostsCreatedByUser(u.getUserID(),1);

        /*Assert*/
        assertEquals(postList, actualReturn);
    }

    @Test
    void getPostById() {
        /*Assign*/
        User myUser = new User();
        List<Like> likeList = new ArrayList<>();
        List<Comment> comsList = new ArrayList<>();
        Post myPost = new Post(1, myUser, "test", "test", "test", "test", likeList, comsList);

        /*Act*/
        Mockito.when(postService.getPostByID(myPost.getPostId())).thenReturn(myPost);
        Post testPost = postController.getPostById(1);
        Mockito.verify(postService).getPostByID(1);

        /*Assert*/
        assertEquals(myPost, testPost);
    }

    @Test
    void getAllPostsTest() {

        /*Assign*/
        User myUser = new User();
        List<Like> likeList = new ArrayList<>();
        List<Comment> comsList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();
        Post myPost = new Post(1, myUser, "test", "test", "test", "test", likeList, comsList);
        Post myPost2 = new Post(2, myUser, "test", "test", "test", "test", likeList, comsList);
        postList.add(myPost);
        postList.add(myPost2);

        /*Act*/
        Mockito.when(postService.getAllPosts()).thenReturn(postList);
        List<Post> actualList = postController.getAllPosts();
        Mockito.verify(postService).getAllPosts();

        /*Assert*/
        assertEquals(actualList, postList);

    }

    @Test
    void getTwentyPostsTest() {
        /*Assign*/
        User myUser = new User();
        List<Like> likeList = new ArrayList<>();
        List<Comment> comsList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();
        Post myPost = new Post(1, myUser, "test", "test", "test", "test", likeList, comsList);
        Post myPost2 = new Post(2, myUser, "test", "test", "test", "test", likeList, comsList);
        postList.add(myPost);
        postList.add(myPost2);

        List<Post> postList2 = new ArrayList<>();
        Post myPost3 = new Post(3, myUser, "test", "test", "test", "test", likeList, comsList);
        Post myPost4 = new Post(4, myUser, "test", "test", "test", "test", likeList, comsList);
        postList.add(myPost3);
        postList.add(myPost4);


        /*Act*/
        Mockito.when(postService.getFollowingPosts(0,1)).thenReturn(postList);
        Mockito.when(postService.getFollowingPosts(1,1)).thenReturn(postList2);
        List<Post> actualList = postController.getTwentyPosts(0,1);
        List<Post> actualList2 = postController.getTwentyPosts(1,1);

        /*Assert*/
        Mockito.verify(postService).getFollowingPosts(0,1);
        Mockito.verify(postService).getFollowingPosts(1,1);
        assertEquals(actualList,postList);
        assertEquals(actualList2, postList2);

    }

}