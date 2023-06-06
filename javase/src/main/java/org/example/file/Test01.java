package org.example.file;

import java.io.File;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.file
 * @date 2023/6/5 22:33
 * @description: 公司
 */
public class Test01 {
    public static void main(String[] args) {
        String path ="C:\\Users\\liulq\\Desktop\\桌面资料\\00.java面试宝典脑图.txt";
        File file = new File(path);
        System.out.println(file);
    }
}
