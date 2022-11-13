package org.example.jdk8.jdk8Interface.service;

import java.time.Duration;
import java.time.Instant;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.jdk8.jdk8Interface.service
 * @date 2022/11/13 18:43
 * @description: Stream并行流操作
 */
public class ParallelStream1 {
    public static void main(String[] args) {
        Instant start = Instant.now();
        long sun= 0;
        for (int i = 0; i <= 50000000000L; i++) {
            sun +=i;
        }
        System.out.println(sun);
        Instant end = Instant.now();
        System.out.println("五百亿求和耗费的时间为："+ Duration.between(start,end).toMillis());
    }
}
