package org.example.jdk8.jdk8Interface.service;

import java.time.Duration;
import java.time.Instant;
import java.util.OptionalLong;
import java.util.function.LongBinaryOperator;
import java.util.stream.LongStream;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.jdk8.jdk8Interface.service
 * @date 2022/11/13 18:37
 * @description: 并行流操作
 */
public class ParallelStream {
    public static void main(String[] args) {
        Instant start = Instant.now();
        LongStream longStream = LongStream.rangeClosed(0, 50000000000L);
        //多线程处理
        OptionalLong result = longStream.parallel().reduce(new LongBinaryOperator() {
            @Override
            public long applyAsLong(long left, long right) {
                return right + left;
            }
        });
        System.out.println(result.getAsLong());
        Instant end = Instant.now();
        System.out.println("五百亿求和耗费的时间为："+ Duration.between(start,end).toMillis());
    }
}
