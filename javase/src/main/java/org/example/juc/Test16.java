package org.example.juc;

import java.util.Date;
import java.util.stream.Stream;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.juc
 * @date 2023/11/20 10:58
 * @description: 公司
 */
public class Test16 {
    public static void main(String[] args) {
        //数组
        int[] arr = new int[10];
        long limit = 10;
        for (Integer i = 0; ; i = i + 1) {
            if (limit-- == 0) break;
            arr[i] = i;
        }
        Stream.of(arr).forEach(System.out::println);
        System.out.println("----------------------------------------");
    }
}
