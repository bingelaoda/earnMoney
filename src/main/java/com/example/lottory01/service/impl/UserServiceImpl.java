package com.example.lottory01.service.impl;

import com.example.lottory01.bean.User;
import com.example.lottory01.dao.UserDao;
import com.example.lottory01.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserServiceImpl
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void register(User user) {
        userDao.save(user);
    }

    @Override
    public User findOne(String username, String password) {
        return userDao.findByUsernameAndPassword(username,password);
    }
}
