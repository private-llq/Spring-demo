package org.example.springdemo.test;

import org.example.springdemo.model.BookEntity;
import org.example.springdemo.model.MayikUserEntity;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.test
 * @date 2022/11/26 22:58
 * @description: 测试
 */
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.获取class方式 直接类名称
        Class<MayikUserEntity> mayikUserEntityClass = MayikUserEntity.class;
        //2.new 对象 通过对象获取class springioc容器 根据class获取对象
        MayikUserEntity mayikUserEntity = new MayikUserEntity();
        Class<? extends MayikUserEntity> aClass = mayikUserEntity.getClass();
        //3. 类的完整路径地址 包的名称+类名称组合  第三种 企业使用最多的
        Class<?> aClass1 = Class.forName("org.example.springdemo.model.MayikUserEntity");
        System.out.println(aClass1);
        System.out.println(mayikUserEntityClass);
        System.out.println(aClass);
    }
}
