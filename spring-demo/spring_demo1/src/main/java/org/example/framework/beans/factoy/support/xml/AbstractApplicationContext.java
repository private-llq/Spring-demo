package org.example.framework.beans.factoy.support.xml;

import org.example.framework.context.support.ApplicationContext;
import org.example.framework.context.support.BeanDefinitionReader;
import org.example.framework.context.support.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * ApplicationContext 接口的子实现类，用于立即加载
 * @author tt11
 * @create 2022-09-03 15:49
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    // 声明解析器变量，由子类去初始化（因为可能有多种解析器）
    protected BeanDefinitionReader beanDefinitionReader;
    // 声明map集合，用来存放 bean 对象
    protected Map<String, Object> singletonObjects = new HashMap<>();
    // 用来存放配置文件路径，在子类中初始化
    protected String configLocation;

    @Override
    public void refresh() throws Exception {
        // 加载配置文件
        beanDefinitionReader.loadBeanDefinitions(configLocation);
        // 初始化 bean
        finishBeanInitialization();
    }
    // bean的初始化
    private void finishBeanInitialization() throws Exception {
        // 获取注册表
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            // 初始化对象，将 
            getBean(beanName);
        }
    }
}