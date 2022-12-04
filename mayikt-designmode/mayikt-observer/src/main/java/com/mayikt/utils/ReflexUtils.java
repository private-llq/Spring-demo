package com.mayikt.utils;

import com.mayikt.observer.MsgObServer;
import org.reflections.Reflections;

import java.util.Set;

/**
 * @author 余胜军
 * @ClassName ReflexUtils
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class ReflexUtils {
    public static Set<Class> getInterfaceImpls(Class c) {
        Reflections reflections = new Reflections("com.mayikt");
        //Filter是个接口，获取在指定包扫描的目录所有的实现类
        Set<Class> classes = reflections.getSubTypesOf(c);
        return classes;
    }


}
