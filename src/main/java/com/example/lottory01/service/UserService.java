package com.example.lottory01.service;

import com.example.lottory01.bean.User;

/**
 * ClassName:UserService
 * Description:
 */
public interface UserService {
    void register(User user);

    User findOne(String username, String password);
}
