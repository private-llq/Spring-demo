package com.mayikt.mybatis;

import com.mayikt.mybatis.ext.MayiktInsert;
import com.mayikt.utils.MayiktJdbcUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author 余胜军
 * @ClassName MybatisInvocationHandler
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class MybatisInvocationHandler implements InvocationHandler {
    private Class mapperClass;

    public MybatisInvocationHandler(Class mapperClass) {
        this.mapperClass = mapperClass;

    }

    /**
     * Method method 接口 addOrder方法
     * UserMapper    没有具体实现类---是有我们jdk动态代理生成代理类
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.当我们在调用UserMapper.addUser（）；
        //2.使用java反射机制获取该方法上 注解
        MayiktInsert mayiktInsert = method.getDeclaredAnnotation(MayiktInsert.class);
        //3.获取注解中sql语句 执行
        String insertSql = mayiktInsert.value();
        Connection connection = MayiktJdbcUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        //4.执行完毕之后将该返回结果 返回
        return preparedStatement.executeUpdate();

    }

    /**
     * 参数1：类加载器 传递 目标对象的类加载器
     * 参数2：目标对象实现的接口
     * JDK动态代理底层 生成的代理类  实现该接口
     *
     * @param <T> 传递 目标对象
     * @return
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(mapperClass.getClassLoader(), new Class[]{mapperClass},
                this);
    }

}
