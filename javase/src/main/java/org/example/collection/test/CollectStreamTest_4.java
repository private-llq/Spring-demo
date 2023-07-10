package org.example.collection.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CollectStreamTest_4 {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User(1,"张三",19));
        list.add(new User(3,"李四四",23));
        list.add(new User(3,"王五五五",22));
        list.add(new User(4,"赵六六六六",18));

        /**
         *所有的名称用"--"连接起来
         */
        String collect = list.stream().map(User::getName).collect(Collectors.joining("--"));
        System.out.println(collect);//张三--李四四--王五五五--赵六六六六

        User name = User.builder().sex(1).age(0).name("name").build();
        System.out.println(name);

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class User{
    private  int sex;
    private  String name;
    private  int age;
}