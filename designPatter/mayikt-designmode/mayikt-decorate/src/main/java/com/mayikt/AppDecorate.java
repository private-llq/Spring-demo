package com.mayikt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 余胜军
 * @ClassName AppDecorate
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@SpringBootApplication
@MapperScan("com.mayikt.mapper")
public class AppDecorate {
    public static void main(String[] args) {
        SpringApplication.run(AppDecorate.class);
    }
}
