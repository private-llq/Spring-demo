package com.mayiakt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 余胜军
 * @ClassName AppStrategy
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@SpringBootApplication
@MapperScan("com.mayiakt.mapper")
public class AppStrategy {
    public static void main(String[] args) {
        SpringApplication.run(AppStrategy.class);
    }
}
