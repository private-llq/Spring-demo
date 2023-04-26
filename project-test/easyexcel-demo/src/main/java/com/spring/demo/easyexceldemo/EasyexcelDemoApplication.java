package com.spring.demo.easyexceldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EasyexcelDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyexcelDemoApplication.class, args);
    }

}
