package org.example.jdk8.jdk8Interface.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.jdk8.jdk8Interface.service
 * @date 2022/11/13 17:37
 * @description: Stream的计算
 */
public class StreamMath {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("llq",12));
        userList.add(new User("lishi",16));
        userList.add(new User("lishi",123));
        userList.add(new User("zhanshan",14));


        //加法
        Optional<User> sum = userList.stream().reduce(new BinaryOperator<User>() {
            @Override
            public User apply(User user, User user2) {
                User user1 = new User("sum", user.getAge() + user2.getAge());
                return user1;
            }
        });
        System.out.println(sum.get());


        //stream写法
        Optional<User> sum1 = userList.stream().reduce((user, user2) -> {
            User user1 = new User("sum", user.getAge() + user2.getAge());
            return user1;
        });


        //最大和最小的元素
        //匹配
        System.out.println(userList.stream().anyMatch(user -> "lishi".equals(user.getName())));
       //分页
        userList.stream().skip(1).limit(2).forEach(user -> System.out.println(user));
    }
}
