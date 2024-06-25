package com.example.springmybatisplus2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springmybatisplus2.dao")
public class SpringMybatisplus2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisplus2Application.class, args);
    }

}
