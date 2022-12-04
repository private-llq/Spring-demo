package org.example.springdemo.service.proxy;

import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.service.proxy
 * @date 2022/12/3 23:25
 * @description: 公司
 */
public class MybatisJdkInvocationHandler implements InvocationHandler {
    private Class mapperClass;

    public MybatisJdkInvocationHandler(Class mapperClass) {
        this.mapperClass = mapperClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 使用java反射技术获取该方法上的注解
        MayiktInsert declaredAnnotation = method.getDeclaredAnnotation(MayiktInsert.class);
        String insertSql = declaredAnnotation.value();
        if (StringUtils.isEmpty(insertSql)) {
            return null;
        }
        // 执行该sql语句
//        Connection connection = MayiktJdbcUtils.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
//        int result = preparedStatement.executeUpdate();
//        return result;
        return null;
    }


    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(mapperClass.getClassLoader(), new Class[]{mapperClass}, this);
    }

}