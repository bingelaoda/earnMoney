package com.example.lottory01.bean;

import lombok.Data;

@Data
public class CartItem {

    private String red;

    private String blue;

    private int count;

    private double price=2;

    private double subtotal;

    public double getSubtotal(){
        return price*count;
    }
}
