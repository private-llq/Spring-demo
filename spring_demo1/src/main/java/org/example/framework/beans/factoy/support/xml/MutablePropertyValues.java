package org.example.framework.beans.factoy.support.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.framework.beans.factoy.support.xml
 * @date 2022/11/19 16:56
 * @description:  用来存储和管理多个 PropertyValue 对象
 */
public class MutablePropertyValues implements Iterable<PropertyValue>{

    // 定义 list 集合，用来存储 PropertyValue 对象
    private final List<PropertyValue> propertyValueList;

    public MutablePropertyValues() {
        this.propertyValueList = new ArrayList<>();
    }

    public MutablePropertyValues(List<PropertyValue> propertyValueList) {
        if (propertyValueList == null) {
            this.propertyValueList = new ArrayList<>();
        } else {
            this.propertyValueList = propertyValueList;
        }
    }

    // 获取所有的 PropertyValue 对象，以数组形式返回
    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[propertyValueList.size()]);
    }

    // 根据 propertyName 来获取 PropertyValue 对象
    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyName == propertyValue.getName()) {
                return propertyValue;
            }
        }
        return null;
    }

    // 判断集合是否为空
    public boolean isEmpty() {
        return propertyValueList.isEmpty();
    }

    // 判断是否包含指定 name 的 PropertyValue 对象
    public boolean contains(String propertyName) {
        return getPropertyValue(propertyName) != null;
    }

    // 添加 PropertyValue 对象
    public MutablePropertyValues addPropertyValue(PropertyValue propertyValue) {
        // 判断是否有重复
        for (int i = 0; i < propertyValueList.size(); i++) {
            PropertyValue currentPv = propertyValueList.get(i);
            if (currentPv.getName() == propertyValue.getName()) {
                // 重复，覆盖掉原来的值
                propertyValueList.set(i, propertyValue);
                return this;
            }
        }
        // 不重复
        propertyValueList.add(propertyValue);
        return this; // 为了可以链式调用
    }

    // 获取迭代器对象
    @Override
    public Iterator<PropertyValue> iterator() {
        return propertyValueList.iterator();
    }
}
