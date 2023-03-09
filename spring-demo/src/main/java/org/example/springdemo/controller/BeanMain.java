package org.example.springdemo.controller;

import org.example.springdemo.model.UserEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.controller
 * @date 2022/11/26 15:32
 * @description: 测试
 */
public class BeanMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app =
                new ClassPathXmlApplicationContext("spring06.xml");
        UserEntity mayiktBean = (UserEntity) app.getBean("mayiktBean");
        UserEntity mayiktBean1 = (UserEntity) app.getBean("mayiktBean");
        System.out.println(mayiktBean == mayiktBean1);
        System.out.println(mayiktBean);
        System.out.println(mayiktBean1);
    }
}
