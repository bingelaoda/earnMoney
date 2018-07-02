package com.example.lottory01.controller;

import com.example.lottory01.bean.Comment;
import com.example.lottory01.bean.User;
import com.example.lottory01.service.CommentService;
import com.example.lottory01.utils.TimeUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * ClassName:CommentController
 * Description:
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    public String addComment(Comment comment, HttpSession httpSession){
        comment.setTime(TimeUtils.oneDate());
        User user = (User) httpSession.getAttribute("user");
        comment.setUsername(user.getUsername());
        commentService.save(comment);
        return "redirect:/note/noteDetail?nid="+comment.getNid();
    }
}
