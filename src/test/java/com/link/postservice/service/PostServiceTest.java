package com.link.postservice.service;

import com.link.postservice.dao.PostDao;
import com.link.postservice.model.Comment;
import com.link.postservice.model.Like;
import com.link.postservice.model.Post;
import com.link.postservice.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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


    @AfterEach
    void tearDown(){}

    @Test
    void save(){
        User user = new User();
        List<Like> likes = new ArrayList<Like>();
        List<Comment> comments= new ArrayList<Comment>();
        Post post = new Post(
                2,
                user,
                "test body",
                "test img url",
                "test youtube url",
                "test time",
                likes,
                comments
        );

        postService.save(post);
        Mockito.verify(postDao).save(post);
    }

    @Test
    void updatePost() {
        Post testPost = new Post();

        Mockito.when(postDao.save(testPost)).thenReturn(testPost);
        postService.updatePost(testPost);

        ArgumentCaptor<Post> myCaptor = ArgumentCaptor.forClass(Post.class);

        Mockito.verify(postDao).save(myCaptor.capture());

    }

    @Test
    void getPostsCreatedByUser() {
        User u = new User();
        u.setUserId(1);

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

        Mockito.when(postDao.findAllByUserUserId(u.getUserId())).thenReturn(postList);

        List<Post> actualReturn = postService.getPostsCreatedByUser(u.getUserId());

        Mockito.verify(postDao).findAllByUserUserId(u.getUserId());

        assertEquals(postList, actualReturn);
    }

    @Test
    void getPostById() {

        User myUser = new User();
        List<Like> likeList = new ArrayList<>();
        List<Comment> comsList = new ArrayList<>();
        Post myPost = new Post(1, myUser, "test", "test", "test", "test", likeList, comsList);

        Mockito.when(postDao.findById(myPost.getPostId())).thenReturn(myPost);

        Post testPost = postService.getPostById(1);

        Mockito.verify(postDao).findById(1);

        assertEquals(myPost, testPost);
    }


<<<<<<< HEAD
}
=======
    @Test
    void getAll	() {
        //Create two post for Mockito to test
        List<Post> tempList = new ArrayList<>();
        Post post1 = new Post();
        post1.setPostId(1);
        post1.setUser(new User(1, "MeMe", "MeMe.pic"));
        post1.setPostContent("blablabla");
        post1.setPostImageUrl("fdafdsa");
        post1.setYoutubeUrl("dfdfdd");

        Post post2 = new Post();
        post2.setPostId(2);
        post2.setUser(new User(2, "YouYou", "YouYou.pic"));
        post2.setPostContent("blablabla");
        post2.setPostImageUrl("fdafdsa");
        post2.setYoutubeUrl("dfdfdd");

        tempList.add(post1);
        tempList.add(post2);

        //When find all is called in postDao return the hardcoded array above
        Mockito.when(postDao.findAll()).thenReturn(tempList);

        List<Post> actualReturn = postService.getAllPosts();

        Mockito.verify(postDao).findAll();

        //test values are the same
        assertEquals(tempList, actualReturn);
    }

}

>>>>>>> 418cd5b5499c01374ac89bb8584e510165bb0a56
