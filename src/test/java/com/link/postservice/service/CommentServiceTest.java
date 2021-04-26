package com.link.postservice.service;

import com.link.postservice.dao.CommentDao;
import com.link.postservice.model.Comment;
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
class CommentServiceTest {

    @Mock
    CommentDao commentDao;

    CommentService commentService;

    @BeforeEach
    void setUp() {
        commentService = new CommentService(commentDao);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addComment() {
        Comment comment = new Comment();
        Mockito.when(this.commentDao.save(comment)).thenReturn(comment);
        commentService.addComment(comment);

        ArgumentCaptor<Comment> myCaptor = ArgumentCaptor.forClass(Comment.class);
        Mockito.verify(commentDao).save(myCaptor.capture());
    }
}