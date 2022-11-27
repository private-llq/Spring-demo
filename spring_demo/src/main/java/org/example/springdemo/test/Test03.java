package org.example.springdemo.test;

import org.example.springdemo.model.MayikUserEntity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.test
 * @date 2022/11/26 22:58
 * @description: 测试
 */
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("org.example.springdemo.model.MayikUserEntity");
        MayikUserEntity mayikUser = (MayikUserEntity) aClass.newInstance();
        System.out.println(mayikUser);


        Constructor<?> constructor = aClass.getConstructor(String.class, Integer.class);
        MayikUserEntity mayikUserEntity = (MayikUserEntity)constructor.newInstance("liuliangqi", 26);
        System.out.println(mayikUserEntity);
    }
}
