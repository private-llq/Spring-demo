package org.example.library;

import java.util.Arrays;
import java.util.List;

/**
 *  anyMatch ：判断集合中是否有元素满足条件，返回boolean值
 */
public class AnyMatchStreamTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("dss", "fsd", "dae", "ces");

        /**
         * 案例：
         *      判断是否有集合中是否有元素包含'a'字符
         *      我们自定义条件中遇到第一个true，就直接返回了
         */
        boolean bool = list.stream().anyMatch(s -> {
            System.out.println(s);  //结果：dss  fsd  dae  发现第三个已经符合要求，第四个就没判断
            return s.contains("g");   //包含a返回true
        });
        System.out.println(bool);  //结果：true
    }
}