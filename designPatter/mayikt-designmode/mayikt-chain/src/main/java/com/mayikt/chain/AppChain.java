package com.mayikt.chain;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 余胜军
 * @ClassName AppChain
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@SpringBootApplication
@MapperScan("com.mayikt.chain.mapper")
public class AppChain {
    public static void main(String[] args) {
        SpringApplication.run(AppChain.class);
    }
}
