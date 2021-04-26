package com.link.postservice.service;

import com.link.postservice.dao.UserDao;
import com.link.postservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * <p>Calls user dao to create a user object</p>
     * @param user - The user to create
     */
    public void duplicateUser(User user){
        userDao.save(user);
    }
}
