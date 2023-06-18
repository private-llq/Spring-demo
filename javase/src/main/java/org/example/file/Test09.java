package org.example.file;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.file
 * @date 2023/6/18 13:43
 * @description: 公司
 */
public class Test09 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        //增
        prop.put("海绵宝宝", "派大星");
        prop.put("章鱼哥", "蟹老板");
        prop.put("玛卡巴卡", "依古比古");

        //第二种方式
        Set<Map.Entry<Object, Object>> entries = prop.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + "---" + value);
        }
    }
}
