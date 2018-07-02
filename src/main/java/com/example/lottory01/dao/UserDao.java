package com.example.lottory01.dao;

import com.example.lottory01.bean.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassName:UserDao
 * Description:
 */
public interface UserDao extends JpaRepository<User,String> {
    User findByUsernameAndPassword(String username, String password);
}
