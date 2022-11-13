package org.example.jdk8.jdk8Interface.service;

import java.util.Optional;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.jdk8.jdk8Interface.service
 * @date 2022/11/13 19:07
 * @description: Optional测试
 */
public class OptionalTest {
    public static void main(String[] args) {
        System.out.println(OptionalTest.getOrderName());
        String userName = null;
        /**
         * ofNullable 可以允许传递一个空值对象
         * of 不允许传递一个控制对象
         */
        Optional<String> userName1 = Optional.ofNullable(userName);
//        Optional<String> userName2 = Optional.of(userName);
//        System.out.println(userName1.get());
        //返回false 则表示值是为空  true 值不为空
        boolean present = userName1.isPresent();
        System.out.println(present);

    }


    public static String getOrderName(){
        User user = new User("liulq", 25);
//        if (user !=null){
//            String userName= user.getName();
//            if (userName !=null){
//                return userName.toLowerCase();
//            }
//        }
        return Optional.ofNullable(user).map((e->e.getName())).map(name->name.toLowerCase()).orElse("df");
    }
}
