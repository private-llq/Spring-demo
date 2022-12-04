package org.example.springdemo.service.mapper;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.service.mapper
 * @date 2022/12/3 23:31
 * @description: 公司
 */
public class MapperProxy {
    public static UserMapper getUserMapper(Class mapperClass) {
//        return new com.mayikt.mybatis.MybatisInvocationHandler(mapperClass).getProxy();
        return null;
    }



    public static void main(String[] args) {
        // 将jdk动态生成好的 class 存放本地
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserMapper userMapper = MapperProxy.getUserMapper(UserMapper.class);
        int i = userMapper.addUser();
        System.out.println(i);
    }
}
