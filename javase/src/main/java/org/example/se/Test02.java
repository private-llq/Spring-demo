package org.example.se;

import com.google.common.collect.ImmutableList;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.se
 * @date 2024/6/25 21:28
 * @description: 公司
 */
public class Test02 {
    public static void main(String[] args) throws Exception {
            List<String> strList = ImmutableList.of("Hollis", "公众号：Hollis", "博客：www.hollischuang.com");
            strList.forEach( s -> { System.out.println(s); } );

        ArrayList<Integer> list = new ArrayList<>();
        Method add = list.getClass().getMethod("add", Object.class);
        add.invoke(list, "Java反射机制实例");
        System.out.println(list.get(0));


    }
}
