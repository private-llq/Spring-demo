package com.example.springimport.doc;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        //test.yaml文件放在resource目录下即可，spring为根变量，也就是我们想要获取的url这个键的源头的那个键
        String value=YamlUtil.getValueByKey("values.yaml","spring","application");
        System.out.println("value:"+value);
    }
}