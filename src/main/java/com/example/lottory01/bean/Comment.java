package com.example.lottory01.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "comment")
@Data
public class Comment {
    //本条评论的编号
    @Id
    @GeneratedValue
    private Integer cid;
    //评论的是哪个主题的帖子
    private String nid;
    //评论的内容
    private String content;
    //评论发表的时间
    private String time;
    //评论者的名称
    private String username;
}