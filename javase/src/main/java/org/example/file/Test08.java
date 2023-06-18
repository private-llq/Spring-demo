package org.example.file;

import java.util.Properties;
import java.util.Set;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.file
 * @date 2023/6/18 13:42
 * @description: 公司
 */
public class Test08 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        //增
        prop.put("海绵宝宝","派大星");
        prop.put("章鱼哥","蟹老板");
        prop.put("玛卡巴卡","依古比古");

        //遍历
        //第一种方式
        Set<Object> objects = prop.keySet();
        for (Object key : objects) {
            Object value = prop.get(key);
            System.out.println(key+"---"+value);
        }

    }
}
