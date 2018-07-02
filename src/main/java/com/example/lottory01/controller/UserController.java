package com.example.lottory01.controller;

import com.aliyuncs.exceptions.ClientException;
import com.example.lottory01.bean.User;
import com.example.lottory01.service.UserService;
import com.example.lottory01.utils.BallUtils;
import com.example.lottory01.utils.SMSUtils;
import com.example.lottory01.utils.UUIDUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * ClassName:UserController
 * Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userServiceImpl;

    @RequestMapping("/registerUI")
    public String registerUI(){
        return "register";
    }

    @PostMapping("/register")
    public String register(User user,HttpSession httpSession,String msg,Model model){
        //增补剩余信息
        user.setHeadimg("/img/icon.jpg");
        user.setMoney(100);
        user.setState(1);

        String id = UUIDUtils.getId();
        user.setUid(id);

        //判断验证码是否正确
        String sendMsg = (String) httpSession.getAttribute("sendMsg");
        System.out.println("sendMsg="+sendMsg);
        if (!msg.equals(sendMsg)){
            model.addAttribute("msg2","短信验证码不匹配");
            return "register";
        }
        userServiceImpl.register(user);

        return "redirect:/user/loginUI";
    }
    @GetMapping("/loginUI")
    public String loginUI(){
        return "login";
    }
    @PostMapping("/login")
    public String login(String username, String password, Model model,HttpSession session){

        User user = userServiceImpl.findOne(username,password);

        System.out.println("user="+user);
        if (user==null){
            model.addAttribute("msg","账号或密码错误");
            return "login";
        }
        session.setAttribute("user",user);
        return "redirect:/";
    }

    @GetMapping("/sendSms")
    @ResponseBody
    public  String sendSms(HttpSession httpSession,String mobile){
        String sendSms = null;
        try {
            sendSms = SMSUtils.sendSms(mobile);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        System.out.println("0000000");
        System.out.println(sendSms);
        httpSession.setAttribute("sendMsg",sendSms);

        return "success";
    }
    @GetMapping("userUI")
    public String userUI(Model model){
        List<String> redBalls = BallUtils.randomRed();
        String blueBall = BallUtils.randomBlue();
        model.addAttribute("redBalls",redBalls);
        model.addAttribute("blueBall",blueBall);
        return "user";
    }
}
