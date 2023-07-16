package com.example.jiguangdemo;

import com.example.jiguangdemo.util.XxlJobProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


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
