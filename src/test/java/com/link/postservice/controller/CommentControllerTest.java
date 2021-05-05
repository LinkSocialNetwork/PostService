package com.link.postservice.controller;

import com.link.postservice.model.Comment;
import com.link.postservice.model.CustomResponseMessage;
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
        Comment comment = new Comment();

        /*Act*/
        CustomResponseMessage actualResult = this.commentController.createNewComment(comment);

        /*Assert*/
        Mockito.verify(commentService).addComment(comment);
    }

}