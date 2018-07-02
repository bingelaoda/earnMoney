package com.example.lottory01.controller;

import com.example.lottory01.bean.BallHistory;
import com.example.lottory01.service.HistoryBallService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * ClassName:IndexController
 * Description:
 */
@Controller
public class IndexController {
    @Autowired
    private HistoryBallService historyBallServiceImpl;
    @GetMapping("/")
    public String accessIndex(Model model){
        Page<BallHistory> pages = historyBallServiceImpl.findAll();
        List<BallHistory> balls = pages.getContent();
        model.addAttribute("balls",balls );
        return "index";
    }
    @GetMapping("/showDetail")
    public String showDetail(String code,Model model){
        BallHistory one = historyBallServiceImpl.findOne(code);
        System.out.println(one);
        model.addAttribute("one",one);
        return "lotteryDetails";

    }

}
