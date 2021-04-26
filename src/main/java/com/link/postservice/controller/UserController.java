package com.link.postservice.controller;

import com.link.postservice.model.User;
import com.link.postservice.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * <p>An endpoint to create a user in the post service, triggered when a user is made in the user service</p>
     * @param user - The user to make
     */
    @PostMapping("/duplicateUser")
    public void createUser(@RequestBody User user){
        userService.duplicateUser(user);
    }
}
