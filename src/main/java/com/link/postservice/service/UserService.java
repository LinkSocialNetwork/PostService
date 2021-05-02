package com.link.postservice.service;

import com.link.postservice.dao.UserDao;
import com.link.postservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Calls user dao to create a user object</p>
     * @param user - The user to create
     */
    public void duplicateUser(User user){
        userDao.save(user);
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Updates a users information</p>
     * @param user - The user information to update
     */
    public void updateUser(User user){
        userDao.save(user);
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>A method to delete a user by its id</p>
     * @param userId - The id of the user to delete
     */
    public void deleteUser(int userId){
        User user = userDao.findById(userId);
        userDao.delete(user);
    }

    public List<User> getAll() {
        return userDao.findAll();
    }
}
