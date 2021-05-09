package com.link.postservice.controller;

import com.link.postservice.model.Comment;
import com.link.postservice.model.CustomResponseMessage;
import com.link.postservice.model.Post;
import com.link.postservice.model.User;
import com.link.postservice.service.CommentService;
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
class CommentControllerTest {

    @Mock
    private CommentService commentService;

    private CommentController commentController;

    @BeforeEach
    void setUp() {
        commentController = new CommentController(commentService);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createSuccessfulComment() {

        /*Assign*/
        User user = new User(2, "YouYou", "YouYou.pic",0);
        Post post = new Post(1, user, "test", "test", "test", "test", null, null);
        Comment comment = new Comment(1,"New Comment","544353245",user,post);

        /*Act*/
        CustomResponseMessage actualResult = this.commentController.createNewComment(comment);

        /*Assert*/
        Mockito.verify(commentService).addComment(comment);
    }

}