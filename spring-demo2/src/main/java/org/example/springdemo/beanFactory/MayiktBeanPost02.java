package org.example.springdemo.beanFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.beanFactory
 * @date 2022/11/27 10:12
 * @description: 公司
 */
public class MayiktBeanPost02 implements BeanPostProcessor, Ordered {
    /**
     * 调用初始化方法之前执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[MayiktBeanPost02:]调用该bean的 init方法之前");
        return bean;
    }

    /**
     * 调用初始化方法之后执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[MayiktBeanPost02:]调用该bean的 init方法之后");
        return bean;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
