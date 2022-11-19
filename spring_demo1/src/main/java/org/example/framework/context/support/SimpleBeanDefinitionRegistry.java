package org.example.framework.context.support;

import org.example.framework.beans.factoy.support.xml.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册表子实现类
 * @author tt11
 * @create 2022-09-03 14:41
 */
public class SimpleBeanDefinitionRegistry implements BeanDefinitionRegistry {
    
    // 定义一个map，用来存储 BeanDefinition 对象
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
    
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public void removeBeanDefinition(String beanName) throws Exception {
        beanDefinitionMap.remove(beanName);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws Exception {
        return beanDefinitionMap.get(beanName);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public int getBeanDefinitionCount() {
        return beanDefinitionMap.size();
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }
}