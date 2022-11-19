package org.example.framework.beans.factoy.support.xml;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.framework.beans.factoy.support.xml
 * @date 2022/11/19 17:32
 *    封装 Bean 对象
 *    id：对象id
 *    className：全类名
 *    Property属性
 */
public class BeanDefinition {
    private String id;
    private String className;
    private MutablePropertyValues propertyValues;

    public BeanDefinition() {
        propertyValues = new MutablePropertyValues();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public MutablePropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(MutablePropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}