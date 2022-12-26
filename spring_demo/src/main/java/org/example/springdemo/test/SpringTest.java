package org.example.springdemo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author liuliangqi
 * @date 2022/12/26 13:59
 * spring 的循环依赖测试
 * Spring 如何解决循环依赖的问题
 */
public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(context.getBean("a", StudentA.class));
    }
}
