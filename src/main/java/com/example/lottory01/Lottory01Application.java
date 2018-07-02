package com.example.lottory01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Lottory01Application {

    public static void main(String[] args) {
        SpringApplication.run(Lottory01Application.class, args);
    }
}
