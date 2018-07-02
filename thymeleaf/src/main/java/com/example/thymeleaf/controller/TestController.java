package com.example.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:TestController
 * Description:
 */
@Controller
public class TestController {

    @GetMapping("/demo1")
    public String demo1(){
        return "demo1";
    }
    @GetMapping("/demo2")
    public String demo2(){
        return "demo2";
    }
    @GetMapping("/demo3")
    public String demo3(){
        return "demo3";
    }
    @GetMapping("/demo4")
    public String demo4(){
        return "demo4";
    }
    @GetMapping("/demo5")
    public String demo5(Model model){
        model.addAttribute("msg",9);
        return "conditionJudge";
    }

    @GetMapping("/demo6")
    public String demo6(Model model){
        List<String> cities = new ArrayList<>();
        cities.add("安庆");
        cities.add("合肥");
        model.addAttribute("cities",cities);
        return "loop";
    }

    @GetMapping("/demo7")
    public String demo7(Model model){
        model.addAttribute("cities","44944");
        return "characterJoint";
    }

}
