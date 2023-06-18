package org.example.file;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.file
 * @date 2023/6/18 14:03
 * @description: 公司
 */
public class Test13 {
    public static void main(String[] args) {
//        Inter i = new Inter(); //接口不能直接实例化
        Inter i = new InterImpl();
        i.show();
    }
}
