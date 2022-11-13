package org.example.jdk8.jdk8Interface.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.jdk8.jdk8Interface.service
 * @date 2022/11/13 17:30
 * @description: Stream的list转为map
 */
public class StreamMap {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("llq",12));
        userList.add(new User("lishi",16));
        userList.add(new User("zhanshan",14));


        //原始的写法
        Map<String,User> userMap = userList.stream().collect(Collectors.toMap(new Function<User, String>() {
            @Override
            public String apply(User user) {
                return user.getName();
            }
        }, new Function<User, User>() {
            @Override
            public User apply(User user) {
                return user;
            }
        }));


        userMap.forEach(new BiConsumer<String, User>() {
            @Override
            public void accept(String s, User user) {
                System.out.println(s+","+user);
            }
        });


        //stream的写法
        Map<String,User> userMap1 = userList.stream().collect(Collectors.toMap(user -> user.getName(), user -> user));
        userMap1.forEach((s, user) -> System.out.println(s+","+user));
    }
}
