package org.example.springdemo.test;

import org.example.springdemo.model.MayikUserEntity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.test
 * @date 2022/11/27 16:43
 * @description: 公司
 */
public class Test05 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> aClass = Class.forName("org.example.springdemo.model.MayikUserEntity");
//        Method[] method = aClass.getMethods();
//        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
//        for (int i = 0; i < declaredConstructors.length; i++) {
//            System.out.println(declaredConstructors[i]);
//        }
        //反射技术调用我的 私有方法
        Method getUsernameMethod = aClass.getDeclaredMethod("getUsername", Integer.class,String.class);
        MayikUserEntity mayikUserEntity = (MayikUserEntity)aClass.newInstance();
        //暴力破解
        getUsernameMethod.setAccessible(true);
        String result = (String) getUsernameMethod.invoke(mayikUserEntity, "llq", "25");
        System.out.println(result);




    }
}
