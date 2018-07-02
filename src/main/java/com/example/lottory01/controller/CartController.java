package com.example.lottory01.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.lottory01.bean.Cart;
import com.example.lottory01.bean.CartItem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * ClassName:SelectController
 * Description:
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping("/choiceBall")
    public String choiceBall(String randomOneFlag,Model model){
        System.out.println(randomOneFlag);
        model.addAttribute("randomOneFlag",randomOneFlag);
        return "choiceBall";
    }

    @GetMapping("/choiceBallUI")
    public String choiceBallUI(){

        return "choiceBall";
    }

    @PostMapping("/addToCart")
    @ResponseBody
    public Map<String ,Integer> saveToCart(String balls, HttpSession httpSession){
        //接收参数

        //调用函数处理
        List<CartItem> cartItems= JSONArray.parseArray(balls, CartItem.class);
        //做出响应
        //首先从session中看能不能取出购物车，不能的话要新建并且添加进session中
        Cart cart = (Cart) httpSession.getAttribute("cart");

        if (cart==null){
            cart = new Cart();
            httpSession.setAttribute("cart",cart);
        }
        //将每一个cartItem装入购物车，并且初始化count值
        System.out.println(cartItems);
        for (int i = 0; i < cartItems.size(); i++) {
            cartItems.get(i).setCount(1);
            cart.add(cartItems.get(i));
        }

        //将购物车中的cartItem数量响应给页面
        Map<String ,Integer> map = new HashMap<>();

        map.put("cartItemSize",cart.getCartItems().size());
        return map;
    }

    //跳转到购物车页面
    @RequestMapping("/showCartUI")
    public String showCart(){
        return "cart";
    }
    @RequestMapping("/removeOne")
    public String removeOne(String ball,HttpSession httpSession){

        Cart cart = (Cart) httpSession.getAttribute("cart");

        cart.remove(ball);
        return "cart";
    }

    @RequestMapping("/removeAll")
    public String removeAll(HttpSession httpSession){
        Cart cart = new Cart();
        httpSession.setAttribute("cart",cart);
        return "cart";
    }


}
