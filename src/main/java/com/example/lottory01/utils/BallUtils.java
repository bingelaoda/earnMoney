package com.example.lottory01.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class BallUtils {

    //随机产生红球
    public static List<String> randomRed(){
        // 04,05,07,11,12,25  33个红球中随机产生 6个红球1个蓝球
        // set 集合 : 不能重复  并且有序
        TreeSet<Integer> sets = new TreeSet();

        while(sets.size() < 6){
            int i = new Random().nextInt(33) + 1; // 1-33
            sets.add(i);
        }

        List<String> balls = new ArrayList<>();
        for (Integer i : sets){
            balls.add(String.format("%02d", i));
        }

        return balls;
    }

    public static String randomBlue(){
        int j = new Random().nextInt(16) + 1;
        String blue = String.format("%02d", j);
        return blue;
    }
}