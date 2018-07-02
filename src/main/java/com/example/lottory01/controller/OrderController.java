package com.example.lottory01.controller;

import com.example.lottory01.bean.Cart;
import com.example.lottory01.bean.CartItem;
import com.example.lottory01.bean.Order;
import com.example.lottory01.bean.OrderItem;
import com.example.lottory01.bean.User;
import com.example.lottory01.service.OrderService;
import com.example.lottory01.utils.UUIDUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * ClassName:OrderController
 * Description:
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/orderList")
    public String orderList(HttpSession httpSession, Model model){

        //在展示orderList的过程当中，需要将数据存储到数据库中
        //从httpSession中获取Cart,并且将cart存储到数据库中
        Cart cart = (Cart) httpSession.getAttribute("cart");
        User user = (User) httpSession.getAttribute("user");
        Collection<CartItem> cartItems = cart.getCartItems();
        Order order = new Order();
        order.setCreateTime(new Date());
        order.setOid(UUIDUtils.getId());
        order.setState(0);
        order.setTotal(cart.getTotal());
        order.setUid(user.getUsername());
        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem cartItem: cartItems
             ) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBlue(cartItem.getBlue());
            orderItem.setRed(cartItem.getRed());
            orderItem.setCount(cartItem.getCount());
            orderItem.setCode("2018020");
            orderItem.setItemid(UUIDUtils.getId());
            orderItem.setOid(order.getOid());

            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        //将order保存到数据库中
        orderService.save(order);
        httpSession.setAttribute("order",order);
        return "redirect:/order/myOrderListUI";
    }

    @RequestMapping("/myOrderListUI")
    public String myOrderListUI(){
        return "myOrderList";
    }
    @RequestMapping("/orderDetail")
    public String orderDetail(){
        return "orderDetail";
    }
}
