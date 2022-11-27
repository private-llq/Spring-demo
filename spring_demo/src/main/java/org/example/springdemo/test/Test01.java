package org.example.springdemo.test;

import org.example.springdemo.model.BookEntity;
import org.example.springdemo.model.MemberEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.test
 * @date 2022/11/26 22:58
 * @description: 测试
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        BookEntity bookEntity = new BookEntity();
        System.out.println(bookEntity.getClass() == BookEntity.class);
        System.out.println(bookEntity.getClass());
        Class<?> aClass = Class.forName("org.example.springdemo.model.BookEntity");
        System.out.println(aClass.getName());
    }
}
