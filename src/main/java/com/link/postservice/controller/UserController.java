package com.link.postservice.controller;

import com.link.postservice.model.User;
import com.link.postservice.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/postservice")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>An endpoint to create a user in the post service, triggered when a user is made in the user service</p>
     * @param user - The user to make
     */
    @PostMapping("/duplicateUser")
    public void createUser(@RequestBody User user){
        userService.duplicateUser(user);
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>An endpoint to update user in database</p>
     * @param user - The user information to update
     */
    @PutMapping("/updateUser")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>An endpoint to delete a user by its id</p>
     * @param userId - The id of the user to delete
     */
    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestBody int userId){
        userService.deleteUser(userId);
    }
}
