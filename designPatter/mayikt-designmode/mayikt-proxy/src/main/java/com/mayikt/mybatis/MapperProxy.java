package com.mayikt.mybatis;

/**
 * @author 余胜军
 * @ClassName MapperProxy
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class MapperProxy {
    public static UserMapper getUserMapper(Class mapperClass) {
        return new MybatisInvocationHandler(mapperClass).getProxy();
    }

    public static void main(String[] args) {
        // 将jdk动态生成好的 class 存放本地
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserMapper userMapper = MapperProxy.getUserMapper(UserMapper.class);
        int i = userMapper.addUser();
        System.out.println(i);
    }
}
