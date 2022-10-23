package org.example.se;

import org.example.test.Test;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.se
 * @date 2022/10/22 23:20
 * @Copyright 值传递与引用传递
 */
public class vauleTest {
    public static void main(String[] agrs) {
        Test test = new Test();
        User user = new User();
        user.setName("小刘");
        user.setGender("男");
        test.pass(user);
        System.out.println(user);
    }

    public static class Test {
    public void pass(User user) {
        User users = new User();
        users.setName("小刘123");
        users.setGender("男123");
        System.out.println(users);
    }
}

    public static class User{
        String name;
        String gender;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }
}
