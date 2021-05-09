package com.link.postservice.service;

import com.link.postservice.dao.UserDao;
import com.link.postservice.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Mock
    UserDao userDao;

    @Autowired
    UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userDao);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void duplicateUser() {
        User testUser = new User();
        testUser.setUserName("asddddddd");
        testUser.setProfileImg("/qqqqqqqqqqqq");
        //Mockito.when(userDao.save(testUser)).thenReturn(null);

        userService.duplicateUser(testUser);

        Mockito.verify(userDao, Mockito.times(1)).save(testUser);
    }

    @Test
    void updateUser() {
        User user = new User(6, "seven", "/rrrrrrrrrrr",0);
        userService.updateUser(user);
    }

    @Test
    void deleteUser() {
        userService.deleteUser(6);
    }

    @Test
    void getAll() {
        //Arrange
        List<User> users = new ArrayList<>();
        User aUser = new User();
        users.add(aUser);
        Mockito.when(userDao.findAll()).thenReturn(users);

        //Act
        List<User> actualReturn = userService.getAll();

        //Assert
        assertEquals(users, actualReturn);
    }
}