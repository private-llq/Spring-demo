package org.example.jdk8.jdk8Interface.service;

import java.util.ArrayList;
  import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.jdk8.jdk8Interface.service
 * @date 2022/11/13 16:08
 * @description: 案例测试
 */
public class Jdk8Test4 {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("llq",12));
        userList.add(new User("lishi",16));
        userList.add(new User("zhanshan",14));
        userList.sort((o1, o2) -> o1.getAge() - o2.getAge());

        userList.forEach((e)->{
            System.out.println(e.toString());
        });
        System.out.println("=================");
        User user = new User("xiaoliu", 15);
        userList.add(user);
        userList.add(user);
        userList.add(user);
        /**
         * 1.串行流 Stream() 单线程
         * 2.并行流parllelStream() 多线程
         */
        Set<User> userSet = userList.stream().collect(Collectors.toSet());
        userSet.forEach(e->{
            System.out.println(e.toString());
        });
    }
}
