package com.link.postservice.controller;

import com.link.postservice.model.*;
import com.link.postservice.service.LikeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class LikeControllerTest {

    LikeController likeController;

    @Mock
    LikeService likeService;

    @Mock
    RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        this.likeController = new LikeController(likeService);
    }

    @Test
    void getAllLikes() {
        /*Assign*/
        List<Like> expectedResult = new ArrayList<>();
        User user = new User(1, "username","/profileImg");
        Post post = new Post(1, user, "THIS IS THE CONTENT", "THIS IS IMAGE URL","YOUTUBE URL","POSTED AT", null, null);
        Like like = new Like (1, user, post);
        expectedResult.add(like);

        /*Act*/
        Mockito.when(this.likeService.findAll()).thenReturn(expectedResult);
        List<Like> actualResult = this.likeController.getAllLikes();

        /*Assert*/
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void deleteLike() {
        /*Assign*/
        CustomResponseMessage expectedResult = new CustomResponseMessage("Like was deleted.");

        /*Act*/
        CustomResponseMessage actualresult = this.likeController.deleteLike(1);

        /*Assert*/
        assertEquals(expectedResult,actualresult);
        Mockito.verify(likeService).delete(1);
    }

    @Test
    void insertNewLikeWithNotification() {
        /*Assign*/
        User user = new User(1, "username","/profileImg");
        Post post = new Post(1, user, "THIS IS THE CONTENT", "THIS IS IMAGE URL","YOUTUBE URL","POSTED AT", null, null);
        Like like = new Like (1, user, post);
        Notification n = new Notification();
        n.setTriggeredId(like.getUser().getUserID());
        n.setTargetId(like.getPost().getUser().getUserID());
        n.setType("like");
        n.setPostId(like.getPost().getPostId());
        CustomResponseMessage expectedResult = new CustomResponseMessage("Like was added.");


        /*Act*/
        //Mockito.doNothing().when(restTemplate).postForObject("http://localhost:9080/api/notificationservice", n, Boolean.class);
        this.likeController.setRestTemplate(this.restTemplate);
        Mockito.when(restTemplate.postForObject("http://localhost:9080/api/notificationservice", n, Boolean.class)).thenReturn(true);
        CustomResponseMessage actualResult = this.likeController.insertNewLike(like);

        /*Assert*/
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void insertNewLikeWithNotificationServiceDown() {
        /*Assign*/
        User user = new User(1, "username","/profileImg");
        Post post = new Post(1, user, "THIS IS THE CONTENT", "THIS IS IMAGE URL","YOUTUBE URL","POSTED AT", null, null);
        Like like = new Like (1, user, post);
        Notification n = new Notification();
        n.setTriggeredId(like.getUser().getUserID());
        n.setTargetId(like.getPost().getUser().getUserID());
        n.setType("like");
        n.setPostId(like.getPost().getPostId());
        CustomResponseMessage expectedResult = new CustomResponseMessage("Notification service down");


        /*Act*/
        this.likeController.setRestTemplate(this.restTemplate);
        Mockito.when(restTemplate.postForObject("http://localhost:9080/api/notificationservice", n, Boolean.class)).thenReturn(false);
        CustomResponseMessage actualResult = this.likeController.insertNewLike(like);

        /*Assert*/
        assertEquals(expectedResult,actualResult);
    }
}