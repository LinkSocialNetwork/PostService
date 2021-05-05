package com.link.postservice.controller;

import com.link.postservice.model.User;
import com.link.postservice.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    UserController userController;

    @Mock
    UserService userService;

    @BeforeEach
    void setUp() {
        this.userController = new UserController(this.userService);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllUsers() {
        /*Assign*/
        List<User> expectedResult = new ArrayList<>();
        expectedResult.add(new User(1,"username1","/user1"));
        expectedResult.add(new User(2,"username2","/user2"));
        expectedResult.add(new User(3,"username3","/user3"));

        /*Act*/
        Mockito.when(userService.getAll()).thenReturn(expectedResult);
        List<User> actualResult = this.userController.getAllUsers();


        /*Assert*/
        assertEquals(expectedResult, actualResult);
        Mockito.verify(userService).getAll();

    }

    @Test
    void createUser() {
        /*Assign*/
        User expectedUser= new User(1,"username1","/user1");

        /*Act*/
        Mockito.when(userService.duplicateUser(expectedUser)).thenReturn(expectedUser);
        User actualResult = this.userController.createUser(expectedUser);

        /*Assert*/
        assertEquals(expectedUser,actualResult);
    }

    @Test
    void updateUser() {
        /*Assign*/
        User user = new User(1,"username1","/user1");

        /*Act*/
        Mockito.doNothing().when(userService).updateUser(user);
        this.userController.updateUser(user);

        /*Assert*/
        Mockito.verify(userService).updateUser(user);
    }

    @Test
    void deleteUser() {
        /*Assign*/
        User user = new User(1,"username1","/user1");

        /*Act*/
        Mockito.doNothing().when(userService).deleteUser(1);
        this.userController.deleteUser(1);

        /*Assert*/
        Mockito.verify(userService).deleteUser(1);
    }
}