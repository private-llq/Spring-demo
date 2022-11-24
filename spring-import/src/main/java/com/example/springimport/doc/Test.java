package com.example.springimport.doc;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws Exception {
        //test.yaml文件放在resource目录下即可，spring为根变量，也就是我们想要获取的url这个键的源头的那个键
//      String value=YamlUtil.getValueByKey("values.yaml","spring","application");
//      System.out.println("value:"+value);
        //spring-demo.spring-import.src.main.java.com.example.springimport.utils
        Object spring = YmlUtils.getYmlRedisPasswordValue("values", "spring-demo.com.example.springimport.utils","application.type");
        System.out.println(spring);
    }
}