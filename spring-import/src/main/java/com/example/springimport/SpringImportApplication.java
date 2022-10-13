package com.example.springimport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.springimport.mapper")
public class SpringImportApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringImportApplication.class, args);
    }

}
