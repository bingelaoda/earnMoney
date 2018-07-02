package com.example.lottory01.service.impl;

import com.example.lottory01.bean.Comment;
import com.example.lottory01.dao.CommentDao;
import com.example.lottory01.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:CommentServiceImpl
 * Description:
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public void save(Comment comment) {
        commentDao.save(comment);
    }
}
