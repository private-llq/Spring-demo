package org.example.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author liuliangqi
 * @date 2023/2/27 9:31
 */
public class LinkedListTest {
    public static void main(String[] args) {
        // 初始化方式；普通方式
        LinkedList<String> list01 = new LinkedList<String>();
        list01.add("a");
        list01.add("b");
        list01.add("c");
        System.out.println("普通方式初始化：" + list01);
        // 初始化方式；Arrays.asList
        LinkedList<String> list02 = new LinkedList<String>(Arrays.asList("a", "b", "c"));
        System.out.println("初始化方式:" + list02);
        // 初始化方式；内部类
        LinkedList<String> list03 = new LinkedList<String>() {
            {
                add("a");
                add("b");
                add("c");
            }
        };
        System.out.println("内部类:" + list03);
        // 初始化方式；Collections.nCopies
        LinkedList<Integer> list04 = new LinkedList<Integer>(Collections.nCopies(10, 0));
        System.out.println("最后的结果：" + list04);

    }
}
