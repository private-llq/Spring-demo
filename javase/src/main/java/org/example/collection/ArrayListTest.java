package org.example.collection;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

/**
 * @author liuliangqi
 * @date 2023/2/23 15:47
 */
@Slf4j
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10);
        list.add("llq");
        list.add("LLQ");
        log.info("list:{}",list);
        //获取ArrayList的元素
        String s = list.get(1);
        log.info("list的值：{}",s);
        list.remove(0);
        System.out.println(list);
        list.clear();
        System.out.println(list);
        int i = list.hashCode();
        System.out.println(i);
        int i1 = list.indexOf(list);
        System.out.println(i1);
        ListIterator<String> stringListIterator = list.listIterator();
        System.out.println(stringListIterator);
        list.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                System.out.println("进来了");
                list.forEach(item->item.equals(s));
                return s;
            }
        });
    }
}
