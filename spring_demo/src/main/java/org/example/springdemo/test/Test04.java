package org.example.springdemo.test;

import java.lang.reflect.Field;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.test
 * @date 2022/11/27 16:43
 * @description: 公司
 */
public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException {
//        Field[] getFields(); 获取所有的公有字段
//        Field[] getDeclaredFields() 获取所有字段 包括：私有、受保护、默认、

//        public Field getField(String fieldName) 获取某个公有的字段
//        public Field[] getDeclaredFields(String fieldName)   获取某个字段(可以是私有的)

        Class<?> aClass = Class.forName("org.example.springdemo.model.MayikUserEntity");
        Field[] fields = aClass.getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i]);
        }
        //2.获取所有字段、包括：私有、受保护的、默认、公有
        Field[] declaredFields = aClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            System.out.println(declaredFields[i]);
        }
    }
}
