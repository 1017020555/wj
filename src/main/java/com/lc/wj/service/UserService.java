package com.lc.wj.service;

import com.lc.wj.dao.UserDao;
import com.lc.wj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public boolean isExitUsername(String username){
        User user = userDao.findByUsername(username);
        return null!=user;
    }

    public User getUserByUsernameAndPassword(String username,String password){
       return  userDao.findByUsernameAndPassword( username, password);
    }

    public User getUserByUsername(String username){
        return userDao.findByUsername(username);
    }

    public void add(User user){
        userDao.save(user);
    }

}
