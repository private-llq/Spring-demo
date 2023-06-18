package org.example.file;

import java.util.Properties;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.file
 * @date 2023/6/18 13:40
 * @description: 公司
 */
public class Test06 {
        public static void main(String[] args) {
            Properties prop = new Properties();
            //增
            prop.put("海绵宝宝","派大星");
            prop.put("章鱼哥","蟹老板");
            prop.put("玛卡巴卡","依古比古");

            //修改： -- put 如果键不存在，那么就添加，如果键存在，那么就覆盖
            prop.put("章鱼哥","六角恐龙");
            System.out.println(prop);
    }
}
