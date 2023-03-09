package org.example.framework.context.support;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.example.framework.beans.factoy.support.xml.BeanDefinition;
import org.example.framework.beans.factoy.support.xml.MutablePropertyValues;
import org.example.framework.beans.factoy.support.xml.PropertyValue;

import java.io.InputStream;
import java.util.List;

/**
 * 用来解析 xml 配置文件
 * @author tt11
 * @create 2022-09-03 15:07
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    // 聚合注册表对象，提供构造器方法
    private BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader() {
        this.registry = new SimpleBeanDefinitionRegistry();
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    /**
     * 加载配置文件，在注册表中注册 bean 信息
     * @param configLocation 配置文件路径
     * @throws Exception
     */
    @Override
    public void loadBeanDefinitions(String configLocation) throws Exception {
        // 1.使用 SAXReader 解析 xml 文件
        SAXReader reader = new SAXReader();
        InputStream is = XmlBeanDefinitionReader.class.getClassLoader().getResourceAsStream(configLocation);
        // 需要一个输入流
        Document document = reader.read(is);
        // 2.得到根标签（beans）
        Element beansElement = document.getRootElement();
        // 3.得到 bean 标签 集合
        List<Element> beanElement = beansElement.elements("bean");
        // 4.解析数据并封装为 BeanDefinition 对象
        for (Element element : beanElement) {
            // 4.1 id
            String id = element.attributeValue("id");
            // 4.2 class
            String className = element.attributeValue("class");
            // 4.3 封装为 BeanDefinition 对象
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setId(id);
            beanDefinition.setClassName(className);

            MutablePropertyValues propertyValues = new MutablePropertyValues();

            // 5.得到 property 标签集合
            List<Element> propertyElements = element.elements("property");
            for (Element property : propertyElements) {
                // 6.解析数据
                // 6.1 name
                String name = property.attributeValue("name");
                // 6.2 ref
                String ref = property.attributeValue("ref");
                // 6.3 value
                String value = property.attributeValue("value");
                PropertyValue propertyValue = new PropertyValue(name, ref, value);
                // 7.封装为 MutablePropertyValues 对象，设置在 BeanDefinition 对象中
                propertyValues.addPropertyValue(propertyValue);
            }
            beanDefinition.setPropertyValues(propertyValues);
            // 8.在注册表中注册对象
            registry.registerBeanDefinition(id, beanDefinition);
        }
    }
}