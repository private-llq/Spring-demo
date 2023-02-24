package com.mayikt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 余胜军
 * @ClassName Test01
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("spring.xml");
        /**
         * spring.xml
         * Spring 为 Resource 接口提供了如下实现类：
         * UrlResource：访问网络资源的实现类。
         * ClassPathResource：访问类加载路径里资源的实现类。
         * FileSystemResource：访问文件系统里资源的实现类。
         * ServletContextResource：访问相对于 ServletContext 路径里的资源的实现类：
         * InputStreamResource：访问输入流资源的实现类。
         * ByteArrayResource：访问字节数组资源的实现类
         */
    }
}
