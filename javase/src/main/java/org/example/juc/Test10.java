package org.example.juc;

import java.util.stream.IntStream;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.juc
 * @date 2023/11/6 16:21
 * @description: 公司
 */
public class Test10 {
    public static void main(String[] args) {
         //for (int i = 0; i <= 100; i++) {
        //    if ( i % 2  == 0 && i % 3 == 0){
        //        System.out.println(i);
        //    }
        //}
        IntStream.rangeClosed(0, 100).filter(i -> i % 2 == 0 && i % 3 == 0).forEach(System.out::println);
    }
}
