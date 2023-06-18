package org.example.file;

import java.util.Properties;
import java.util.Set;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.file
 * @date 2023/6/18 13:45
 * @description: 公司
 */
public class Test10 {
    public static void main(String[] args) {
        // Object setProperty(String key, String value)
        //设置集合的键和值，都是String类型，底层调用 Hashtable方法 put
        Properties prop = new Properties();
        prop.setProperty("浙江","杭州");
        prop.setProperty("湖北","武汉");
        prop.setProperty("河南","浙江");
        System.out.println(prop);

        //String getProperty(String key)
        //使用此属性列表中指定的键搜索属性
        String value = prop.getProperty("湖北");
        System.out.println(value);

        //Set<String> stringPropertyNames()
        //从该属性列表中返回一个不可修改的键集，其中键及其对应的值是字符串
        Set<String> keys = prop.stringPropertyNames();
        for (String key : keys) {
            String value1 = prop.getProperty(key);
            System.out.println(key+"----"+value1);
        }
    }
}
