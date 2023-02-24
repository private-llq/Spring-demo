package com.mayikt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author 余胜军
 * @ClassName AppObServer
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@EnableAsync
@SpringBootApplication
public class AppObServer {
    public static void main(String[] args) {
        SpringApplication.run(AppObServer.class);
    }
}
