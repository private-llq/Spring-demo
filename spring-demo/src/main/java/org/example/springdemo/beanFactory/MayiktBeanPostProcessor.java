package org.example.springdemo.beanFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.beanFactory
 * @date 2022/11/26 23:49
 * @description: 公司
 */
public class MayiktBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[后置处理器调用init方法之前执行操作......]");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("调用该bean的 init方法之后");
        return bean;
    }

    public int getOrder() {
        return 1;
    }
}
