package org.example.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.file
 * @date 2023/6/18 9:07
 * @description: 公司
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
            //创建了字节输入流，准备读数据
            FileInputStream fis = new FileInputStream("D:\\jdk1.8中文版.CHM");
            //创建了字节输出流，准备写数据
            FileOutputStream fos = new FileOutputStream("D:\\ruanjian\\idea\\code-project\\spring-demo\\jdk1.8中文版.CHM");

            //读写数据
            int b;
            while ((b = fis.read())!=-1){
                fos.write(b);
            }

            //释放资源
            fis.close();
            fos.close();
    }
}
