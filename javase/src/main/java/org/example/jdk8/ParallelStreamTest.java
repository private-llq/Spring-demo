package org.example.jdk8;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.jdk8
 * @date 2022/11/9 16:25
 * @Copyright 公司
 */
public class ParallelStreamTest {

    public static void main(String[] args) {
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        System.out.println(numbers);


//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        List<String> strs = numbers.stream().
//                map(num -> Integer.toString(++num)).collect(Collectors.toList());
//        System.out.println(strs);

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        numbers.parallelStream() .forEach(num->System.out.println(Thread.currentThread().getName()+">>"+num));


//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        numbers.parallelStream() .forEach(num->System.out.println(Thread.currentThread().getName()+">>"+num));


//        System.out.println();
//        numbers.forEach(nums->System.out.print(nums));
          String s="123";
          dosomethings(s);
    }
    public static void dosomethings(String s){
        System.out.println(s);
    }



}
