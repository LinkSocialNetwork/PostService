package com.link.postservice.service;

import com.link.postservice.dao.UserDao;
import com.link.postservice.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void duplicateUser() {
        User testUser = new User();
        testUser.setUserName("asddddddd");
        testUser.setProfileImg("/qqqqqqqqqqqq");
        userService.duplicateUser(testUser);
    }

    @Test
    void updateUser() {
        User user = new User(6, "seven", "/rrrrrrrrrrr");
        userService.updateUser(user);
    }

    @Test
    void deleteUser() {
        userService.deleteUser(6);
    }
}