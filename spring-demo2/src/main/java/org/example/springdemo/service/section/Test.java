package org.example.springdemo.service.section;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.service.section
 * @date 2022/12/11 18:06
 * @description: 公司
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app =
                new ClassPathXmlApplicationContext("spring08.xml");
        MayiktService mayiktService = app.getBean("mayiktServiceImpl", MayiktService.class);
        mayiktService.addUser(10);
    }
}
