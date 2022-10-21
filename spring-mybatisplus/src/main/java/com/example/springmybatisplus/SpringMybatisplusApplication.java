package com.example.springmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springmybatisplus.dao")
public class SpringMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisplusApplication.class, args);
    }

}
