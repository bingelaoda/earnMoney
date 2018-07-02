package com.example.thymeleaf.controller;

import lombok.Data;

/**
 * ClassName:User
 * Description:
 */
@Data
public class User {
    private int a;

    public static void main(String[] args){
            User user = new User();
            user.setA(10);
        System.out.println(user.getA());
    }
}




