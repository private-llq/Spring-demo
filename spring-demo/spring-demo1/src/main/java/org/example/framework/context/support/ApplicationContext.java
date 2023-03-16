package org.example.framework.context.support;

/**
 * 自定义的Spring IOC
 */
public interface ApplicationContext extends BeanFactory {
	//进行配置文件加载并进行对象创建
    void refresh() throws IllegalStateException, Exception;
}