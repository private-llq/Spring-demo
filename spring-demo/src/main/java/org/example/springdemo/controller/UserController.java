package org.example.springdemo.controller;

import org.example.springdemo.factory.UserFactory;
import org.example.springdemo.model.BookEntity;
import org.example.springdemo.model.DeptEntity;
import org.example.springdemo.model.EmpEntity;
import org.example.springdemo.model.StuEntity;
import org.example.springdemo.model.StuEntitys;
import org.example.springdemo.model.UserEntity;
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
    public static void main(String[] args) throws Exception {
//        //1.创建spring容器
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        //BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
//        //2.从ioc容器中获取UserService对象
//        UserService userService = applicationContext.getBean("UserService", UserService.class);
//        //3.调用UserService对象的add方法
//        userService.add();


        //余胜军的写法没那么官方、更好理解些
        /**
         * SpringIOC容器底层实现原理：
         * 反射+工厂模式+解析xml技术实现
         * 1.使用解析xml技术 解析spring.xml配置文件； Dom4j
         * 2.获取<bean id=”” class=””/> 类的完整路径地址
         * 3.使用到反射技术初始化对象
         * 4.需要使用工厂模式封装初始化对象
         */
////        new UserEntity()
//        // 1.读取xml配置文件
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        // 2.根据bean的id获取bean对象
//        UserEntity userEntity = classPathXmlApplicationContext.getBean("UserEntity", UserEntity.class);
//        System.out.println(userEntity);
//        userEntity.addUser();
//         UserEntity userFactory = UserFactory.getUserFactory();
//         userFactory.addUser();




//          测试
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        BookEntity bookEntity = classPathXmlApplicationContext.getBean("bookEntity", BookEntity.class);
//        System.out.println(bookEntity);



//        //内部注入Bean
//        ClassPathXmlApplicationContext classPathXmlWebApplicationContext = new ClassPathXmlApplicationContext("spring01.xml");
//        EmpEntity empEntity = (EmpEntity) classPathXmlWebApplicationContext.getBean("empEntity");
//        System.out.println("实体类员工对象的打印的值："+empEntity);



//        //内部注入Bean
//        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("spring02.xml");
//        DeptEntity deptEntity = (DeptEntity) app.getBean("deptEntity");
//        System.out.println("实体类员工对象的打印的值："+deptEntity);



//        //注入集合类型属性
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring03.xml");
//        StuEntity stuEntity = (StuEntity) applicationContext.getBean("stuEntity");
//        System.out.println("集合的值："+stuEntity);

        //集合注入部分提取公共
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("spring05.xml");
        StuEntitys stuEntitys = (StuEntitys) application.getBean("stuEntitys");
        System.out.println("集合注入部分提取公共集合的值："+stuEntitys);



    }

}
