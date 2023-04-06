package org.example.collection.list;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.collection.list
 * @date 2023/4/5 21:48
 * @description: 公司
 */
public class ListCompareUtil {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("小刘",1));
        List<Student> student = new ArrayList<>();
        student.add(new Student("小刘",1,"男"));
        boolean compare = compare(users, student);
        System.out.println(compare);
    }
    public static boolean compare(List<User> userList, List<Student> studentList) {
        if (userList.size() != studentList.size()) {
            return false;
        }
        List<Pair<User, Student>> pairList = IntStream.range(0, userList.size())
                .mapToObj(i -> new Pair<>(userList.get(i), studentList.get(i)))
                .collect(Collectors.toList());
        return pairList.stream().allMatch(pair -> pair.getKey().getName().equals(pair.getValue().getName())
                && pair.getKey().getAge() == pair.getValue().getAge());
    }

}
