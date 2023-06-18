package org.example.file;

import java.util.Properties;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.file
 * @date 2023/6/18 13:41
 * @description: 公司
 */
public class Test07 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        //增
        prop.put("海绵宝宝","派大星");
        prop.put("章鱼哥","蟹老板");
        prop.put("玛卡巴卡","依古比古");

        //查询
        Object value = prop.get("玛卡巴卡");
        System.out.println(value);
    }
}
