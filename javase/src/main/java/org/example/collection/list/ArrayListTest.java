package org.example.collection.list;


import lombok.extern.slf4j.Slf4j;
import org.example.collection.User;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

/**
 * @author liuliangqi
 * @date 2023/2/23 15:47
 */
@Slf4j
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(10);
        list.add("llq");
        list.add("LLQ");
        log.info("list:{}", list);
        //获取ArrayList的元素
        String s = list.get(1);
        log.info("list的值：{}", s);
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
                list.forEach(item -> item.equals(s));
                return s;
            }
        });


        //拷贝测试：
        ArrayList<Object> objectArrayList = new ArrayList<>();
        User user = new User("llq");
        objectArrayList.add("llq");
        objectArrayList.add(user);
        ArrayList clone = (ArrayList) objectArrayList.clone();
        System.out.println("两者的对比:" + (clone == objectArrayList));

        //两者里面元素地址的对比
        System.out.println("两者里面元素地址的对比:" + clone.get(1) == objectArrayList.get(1));
    }
}
