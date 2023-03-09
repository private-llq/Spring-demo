package org.example.springdemo.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.example.springdemo.model.UserEntity;
import org.example.springdemo.utils.Dom4jClass;

import java.io.File;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.factory
 * @date 2022/11/20 10:10
 * @description: user的工厂
 */
public class UserFactory {
    public static UserEntity getUserFactory() throws DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        /**
         * 反射 + 工厂模式 + 解析xml技术实现
         *         1. 使用解析xml技术 解析spring.xml配置文件；
         *         2. 获取<bean id =””class=””/>类的完整路径地址
         *         3. 使用到反射技术初始化对象
         *         4. 需要使用工厂模式封装初始化对象
         */
//        有一个问题：这个方法是静态方法、下面的getUserClass()又不是静态的，如果把下面的getUserClass()方法改成静态的那this又不能使用，所以只能抽出去
        String userClass = new Dom4jClass().getUserClass();
        Class<?> aClass = Class.forName(userClass);
        //默认使用无参构造    newInstance翻译新实例
        UserEntity userEntity = (UserEntity) aClass.newInstance();
        return userEntity;
    }


}
