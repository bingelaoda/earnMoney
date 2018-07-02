package com.example.lottory01.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/**
 购物车对象:
 保存所有的商品 CartItem

 向购物车中添加商品
 删除指定商品
 清空购物车
 购物车总金额
 */
public class Cart {
//    保存所有的商品
    private Map<String,CartItem> map = new HashMap<String,CartItem>();

    //1.添加的方法
    public void add(CartItem cartItem){
        //02,04,13,25,28,29-16
        String key = cartItem.getRed()+"-"+cartItem.getBlue();
        //1.先判断购物车中是否已经包含了这注彩票 key:红球-蓝球 02,04,13,25,28,29 - 16
        if(map.containsKey(key)){
            //2.若包含了,则取出对应的cartItem修改购买的数量
            CartItem oldCartItem = map.get(key);
            oldCartItem.setCount(oldCartItem.getCount()+1);
        }else{
            //3.若没有包含,则直接添加进去
            map.put(key,cartItem);
        }
    }
    //2.删除指定的彩票的方法 02,04,13,25,28,29-16
    public void remove(String key){
        map.remove(key);
    }

    //3.清空的方法
    public void clear(){
        map.clear();
    }

    //4.获取总金额的方法
    public double getTotal(){
        double total = 0;
        //将map中所有cartItem取出来累加里面
        for (String key : map.keySet()) {
            CartItem cartItem = map.get(key);
            total += cartItem.getSubtotal();
        }
        return total;
    }

    //添加一个获取map中所有cartItem的方法
    public Collection<CartItem> getCartItems(){
        Collection<CartItem> values = map.values();
        return values;
    }

}