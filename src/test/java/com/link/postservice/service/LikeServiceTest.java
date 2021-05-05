package com.link.postservice.service;

import com.link.postservice.dao.LikeDao;

import com.link.postservice.model.Comment;
import com.link.postservice.model.Like;
import com.link.postservice.model.Post;
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

        /*Post aPost = new Post();
        //Like aLike = new Like(1,1,aPost);
        Like aNullLike = null;
        likeService.delete(aLike.getLikeId());
        Mockito.verify(likeDao).deleteById(aLike.getLikeId());
        aLike = likeService.getLikeById(aLike.getLikeId());
        assertEquals(aNullLike, aLike);*/

    }

    @Test
    void insertLike(){
        /*Post aPost = new Post();
        Like aLike = new Like(1,1,aPost);
        Mockito.when(likeDao.save(aLike)).thenReturn(aLike);
        assertEquals(aLike, likeService.save(aLike));*/
    }

}
