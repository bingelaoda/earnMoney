package com.example.lottory01.dao;

import com.example.lottory01.bean.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassName:CommentDao
 * Description:
 */
public interface CommentDao extends JpaRepository<Comment,Integer> {
}
