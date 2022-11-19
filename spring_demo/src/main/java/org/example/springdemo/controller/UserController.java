package org.example.springdemo.controller;

import org.example.springdemo.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.controller
 * @date 2022/11/19 9:52
 * @description: 自定义Spring框架
 */
public class UserController {
    public static void main(String[] args) {
        //1.创建spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        //2.从ioc容器中获取UserService对象
        UserService userService = applicationContext.getBean("UserService", UserService.class);
        //3.调用UserService对象的add方法
        userService.add();
    }

}
