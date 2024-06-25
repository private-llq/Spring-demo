package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author liulq
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        int size = 9;

        // 打印表头
        System.out.print("  |");
        for (int i = 1; i <= size; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println("\n--+---------------------------");

        // 打印表格
        for (int i = 1; i <= size; i++) {
            System.out.printf("%2d|", i);
            for (int j = 1; j <= size; j++) {
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }
    }
}
