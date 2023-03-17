package org.example.springdemo.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.utils
 * @date 2022/11/20 10:48
 * @description: 公司
 */
public class Dom4jClass {
    public String getUserClass() throws DocumentException {
        File xmlFile = new File(this.getClass().getResource("/").getPath() + "applicationContext.xml");
        //SAXReader 对象
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(xmlFile);
        Element rootElement = read.getRootElement();
        Element bean = rootElement.element("bean");
        String aClass = bean.attributeValue("class");
        return  aClass;
    }

}
