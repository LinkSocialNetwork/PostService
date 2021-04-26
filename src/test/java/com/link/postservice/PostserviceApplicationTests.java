package com.link.postservice;

import com.link.postservice.dao.PostDao;
import com.link.postservice.model.Post;
import com.link.postservice.model.User;
import com.link.postservice.service.PostService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PostserviceApplicationTests {

	@Mock
	private PostDao postDao;

	private PostService postService;

	@BeforeEach
	void setUp(){
		postService = new PostService(postDao);
	}

	@Autowired
	public PostserviceApplicationTests(PostDao postDao) {
		this.postDao = postDao;
	}


	/**
	 * Unit test for getting all posts
	 */
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
