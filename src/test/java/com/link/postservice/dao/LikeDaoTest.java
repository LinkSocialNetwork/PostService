package com.link.postservice.dao;

import com.link.postservice.model.Comment;
import com.link.postservice.model.Like;
import com.link.postservice.model.Post;
import com.link.postservice.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class LikeDaoTest {

    @Autowired
    LikeDao likeDao;

    @Autowired
    UserDao userDao;

    @Autowired
    PostDao postDao;



//    User user1;
//
//    List<Like> likeList = new ArrayList<>();
//    List<Comment> comsList = new ArrayList<>();
//    Post post1;
//
//
//    Like expectedLike;
//
//    List<Like> expectedLikes = new ArrayList<>();
//



    @BeforeEach
    void setUp() {
//        user1 = userDao.findById(1);
//
////        post1 = new Post(1, user1, "test", "test", "test", "test", likeList, comsList);
//        post1 = new Post();
//        post1.setUser(user1);
//        post1.setPostContent("test");
//        post1.setPostImageUrl("test");
//        post1.setYoutubeUrl("test");
//        post1.setPostedAt("test");
//        post1.setUsersWhoLiked(likeList);
//        post1.setComments(comsList);
//
////        postDao.save(post1);
//
//        expectedLike = new Like(1, user1, post1);
//
//        expectedLikes.add(expectedLike);
//
//        likeDao.save(expectedLike);


    }

    @AfterEach
    void tearDown() {


//        postDao.deleteAll();
//        likeDao.deleteAll();
//        expectedLikes.clear();
    }

    @Test
    void findAllByPostPostId() {
        User user1 = userDao.findById(1);
        User user2 = userDao.findById(2);

        List<Like> likeList = new ArrayList<>();
        List<Comment> comsList = new ArrayList<>();
        Post post1 = new Post(1, user1, "test", "test", "test", "test", likeList, comsList);
        Post post2 = new Post(2, user1, "test", "test", "test", "test", likeList, comsList);

        postDao.save(post1);
        postDao.save(post2);

        Like expectedLike = new Like(1, user2, post2);

        List<Like> expectedLikes = new ArrayList<>();

        expectedLikes.add(expectedLike);

        likeDao.save(expectedLike);
        List<Like> actualLikes = likeDao.findAllByPostPostId(2);
        //this is getting specific like by setting the id
        // problem here is that the id is auto incremented, so we would need find a way to get the like Id that was set
        // in the setUp.
        expectedLikes.get(0).setLikeId(1);

        assertEquals(expectedLikes, actualLikes);

    }

    @Test
    void findAllByUserUserID() {
        User user1 = userDao.findById(1);
        User user2 = userDao.findById(2);

        List<Like> likeList = new ArrayList<>();
        List<Comment> comsList = new ArrayList<>();

        //this is a bad solution. should delete old posts before running this test
        Post post1 = new Post(3, user1, "test", "test", "test", "test", likeList, comsList);
        Post post2 = new Post(4, user1, "test2", "test2", "test2", "test2", likeList, comsList);

        postDao.save(post1);
        postDao.save(post2);

        Like expectedLike = new Like(1, user2, post2);

        List<Like> expectedLikes = new ArrayList<>();

        expectedLikes.add(expectedLike);

        likeDao.save(expectedLike);
        List<Like> actualLikes = likeDao.findAllByUserUserID(2);

        expectedLikes.get(0).setLikeId(1);

        assertEquals(expectedLikes, actualLikes);

    }

    @Test
    void findById() {
        User user1 = userDao.findById(1);

        List<Like> likeList = new ArrayList<>();
        List<Comment> comsList = new ArrayList<>();
        Post post1 = new Post(1, user1, "test", "test", "test", "test", likeList, comsList);

        postDao.save(post1);

        Like expectedLike = new Like(1, user1, post1);

        List<Like> expectedLikes = new ArrayList<>();

        expectedLikes.add(expectedLike);

        likeDao.save(expectedLike);

        Like actualLikes = likeDao.findById(1);

        assertEquals(expectedLike, actualLikes);

    }
}