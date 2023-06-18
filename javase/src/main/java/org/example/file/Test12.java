package org.example.file;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.file
 * @date 2023/6/18 13:50
 * @description: 公司
 */
public class Test12 {
    public static void main(String[] args) throws IOException {
        //void store(Writer writer,String comments)  将集合中的数据以键值对形式保存在本地
        //写出
        Properties prop = new Properties();
        prop.put("张三","23");
        prop.put("李四","24");
        prop.put("王五","25");

        FileWriter fw = new FileWriter("D:\\ruanjian\\idea\\code-project\\spring-demo\\javase\\src\\main\\resources\\prop.properties");
        //将集合中的数据以键值对形式保存在本地
        prop.store(fw,"helloworld");//第二个参数是注释
        //释放资源
        fw.close();
    }
}
