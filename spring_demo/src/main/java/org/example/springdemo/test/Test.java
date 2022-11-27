package org.example.springdemo.test;

import org.example.springdemo.model.MemberEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.test
 * @date 2022/11/26 22:58
 * @description: 测试
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app =
                new ClassPathXmlApplicationContext("spring07.xml");
        MemberEntity memberEntity = app.getBean("memberEntity", MemberEntity.class);
        System.out.println("【第四步:】获取使用到的memberEntity");
        System.out.println(memberEntity);
        //手动关闭bean容器
        app.close();
    }
}
