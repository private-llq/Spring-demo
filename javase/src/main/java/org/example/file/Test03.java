package org.example.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.file
 * @date 2023/6/18 9:24
 * @description: 公司
 */
public class Test03 {
    public static void main(String[] args) throws Exception {
        //创建了一个字节输入流准备读取数据
        FileInputStream fis = new FileInputStream("D:\\jdk1.8中文版.CHM");
        //创建了一个字节输出流准备写入数据
        FileOutputStream fos = new FileOutputStream("D:\\ruanjian\\idea\\code-project\\spring-demo\\jdk1.8中文版.CHM");

        //读取数据
        int len; //本次读到的有效字节个数 --- 这次读了几个字节
        byte[] bys = new byte[1024];
        while ((len = fis.read(bys)) != -1){
            fos.write(bys,0,len);
        }

        //释放资源
        fis.close();
        fos.close();
    }
}
