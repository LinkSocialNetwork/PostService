package com.link.postservice.service;

import com.link.postservice.dao.LikeDao;

import com.link.postservice.model.Comment;
import com.link.postservice.model.Like;
import com.link.postservice.model.Post;
import com.link.postservice.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class LikeServiceTest {

    @Mock
    private LikeDao likeDao;

    private LikeService likeService;


    @BeforeEach
    void setUp() {
        likeService = new LikeService(likeDao);

    }
    @Test
    void deleteLike() {

        Post aPost = new Post();
        User aUser = new User();
        Like aLike = new Like(1,aUser,aPost);
        Like aNullLike = null;
        likeService.delete(aLike.getLikeId());
        Mockito.verify(likeDao).deleteById(aLike.getLikeId());
        aLike = likeService.getLikeById(aLike.getLikeId());
        assertEquals(aNullLike, aLike);

    }

    @Test
    void insertLike(){
        Post aPost = new Post();
        User aUser = new User();
        Like aLike = new Like(1,aUser,aPost);
        Mockito.when(likeDao.save(aLike)).thenReturn(aLike);
        assertEquals(aLike, likeService.save(aLike));
    }

    @Test
    void findAll() {
        //Arrange
        List<Like> likes = new ArrayList<>();
        User newUser = new User();
        Post aPost = new Post();
        Like newLike = new Like(1, newUser, aPost);
        likes.add(newLike);

        //Act
        Mockito.when(likeDao.findAll()).thenReturn(likes);
        List<Like> actualOutput = likeService.findAll();

        //Assert
        Mockito.verify(likeDao).findAll();
        assertEquals(likes, actualOutput);
    }

    @Test
    void getAllLikesByPostID() {
        //Arrange
        List<Like> likes = new ArrayList<>();
        List<Comment> comments = new ArrayList<>();
        User newUser = new User();
        Post aPost = new Post(1, newUser, "test", "img", "youtube", "atime", likes, comments);
        Like newLike = new Like(1, newUser, aPost);
        likes.add(newLike);

        //Act
        Mockito.when(likeDao.findAllByPostPostId(1)).thenReturn(likes);
        List<Like> actualOutput = likeService.findAllByPostPostId(1);

        //Assert
        Mockito.verify(likeDao).findAllByPostPostId(1);
        assertEquals(likes, actualOutput);
    }

    @Test
    void getPostsLikedByUser() {
        //Arrange
        List<Like> likes = new ArrayList<>();
        List<Comment> comments = new ArrayList<>();
        User newUser = new User(1, "uname", "img");
        Post aPost = new Post(1, newUser, "test", "img", "youtube", "atime", likes, comments);
        Like newLike = new Like(1, newUser, aPost);
        likes.add(newLike);

        //Act
        Mockito.when(likeDao.findAllByUserUserID(1)).thenReturn(likes);
        List<Like> actualOutput = likeService.findAllByUserId(1);

        //Assert
        Mockito.verify(likeDao).findAllByUserUserID(1);
        assertEquals(likes, actualOutput);
    }

    @Test
    void getLikeById() {
        //Arrange
        List<Comment> comments = new ArrayList<>();
        User newUser = new User();
        Post aPost = new Post();
        Like newLike = new Like(1, newUser, aPost);

        //Act
        Mockito.when(likeDao.findById(1)).thenReturn(newLike);
        Like actualOutput = likeService.getLikeById(1);

        //Assert
        Mockito.verify(likeDao).findById(1);
        assertEquals(newLike, actualOutput);
    }

    @Test
    void testGetAllLikesByPostID() {
    }

    @Test
    void testGetPostsLikedByUser() {
        //Arrange
        List<Like> likes = new ArrayList<>();
        List<Post> posts = new ArrayList<>();
        List<Comment> comments = new ArrayList<>();
        User newUser = new User(1, "uname", "img");
        Post aPost = new Post(1, newUser, "test", "img", "youtube", "atime", likes, comments);
        Like newLike = new Like(1, newUser, aPost);
        likes.add(newLike);
        posts.add(aPost);

        //Act
        Mockito.when(likeDao.findAllByUserUserID(1)).thenReturn(likes);
        List<Post> actualOutput = likeService.getPostsLikedByUser(1);

        //Assert
        Mockito.verify(likeDao).findAllByUserUserID(1);
        assertEquals(posts, actualOutput);
    }
}
