package org.example.framework.beans.factoy.support.xml;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.framework.beans.factoy.support.xml
 * @date 2022/11/19 16:56
 * @description: 用来封装 bean 标签下的 property 标签的属性
 *    name
 *    ref
 *    value：用来给基本类型 或者 String 赋值
 */
public class PropertyValue {
    private String name;
    private String ref;
    private String value;

    public PropertyValue() {
    }

    public PropertyValue(String name, String ref,String value) {
        this.name = name;
        this.ref = ref;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
