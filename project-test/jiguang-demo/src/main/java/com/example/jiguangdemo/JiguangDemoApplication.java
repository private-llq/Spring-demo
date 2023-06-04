package com.example.jiguangdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JiguangDemoApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(JiguangDemoApplication.class, args);
        }catch (Exception e){
            System.out.println("===================");
        }
        System.out.println("--------------------");
    }

}
