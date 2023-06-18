package org.example.file;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.file
 * @date 2023/6/18 13:48
 * @description: 公司
 */
public class Test11 {
    public static void main(String[] args) throws IOException {
        //void load (Reader reader)         //将本地文件中的键值对数据读取到集合中
        //读取
        Properties prop = new Properties();
        FileReader fr = new FileReader("D:\\ruanjian\\idea\\code-project\\spring-demo\\javase\\src\\main\\resources\\prop.properties");
        //调用完了load方法之后，文件中的键值对数据已经在集合中了
        prop.load(fr);
        System.out.println(prop);
        //关闭资源
        fr.close();
    }
}
