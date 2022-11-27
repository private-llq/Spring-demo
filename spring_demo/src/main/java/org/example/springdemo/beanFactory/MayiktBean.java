package org.example.springdemo.beanFactory;

import org.example.springdemo.model.UserEntity;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.beanFactory
 * @date 2022/11/26 15:33
 * @description: 公司
 */
public class MayiktBean implements FactoryBean<UserEntity> {

    //定义返回类型
    @Override
    public UserEntity getObject() throws Exception {
//        System.out.println("拿到UserEntity对象了");
        return new UserEntity();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
