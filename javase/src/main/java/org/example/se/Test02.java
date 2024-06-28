package org.example.se;

import com.google.common.collect.ImmutableList;
import org.example.collection.Test1;
import org.junit.jupiter.api.TestReporter;

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

        String  str  = "hello world";
        String str1 = new String("12312");
        str.split("1",1);
        String s = str.replaceAll("1", "222");
        System.out.println(s);
        test1();
        test2();
    }

    public static void test1(){
        String str1 = "HelloWorld";
        String str2 = "";
        System.out.println(str1.length());//获取字符串的长度
        System.out.println(str1.charAt(0));//获取字符串指定索引处的字符
        System.out.println(str1.isEmpty());//判断字符穿是否为空
        System.out.println(str2.isEmpty());

        str2 =str1.toUpperCase();//将字符串所有小写变为大写
        System.out.println(str1);//不会去改变str1的值，仍然为原来的字符串，只是返回一个将str1字符全部变为大写后的字符串。
        System.out.println(str2);

        str2 = str2.toLowerCase();//将字符串所有大写变为小写
        System.out.println(str2);

        System.out.println(str1.equals(str2));//比较字符串的内容是否相同
        System.out.println(str1.equalsIgnoreCase(str2));//与equals相同但是忽略大小写
    }
    public static void test2(){
        String str1 = "   he llo world   ";
        System.out.println("---"+str1+"---");
        System.out.println("---"+str1.trim()+"---");//去除字符串两边的空格

        str1 = str1.concat("abc");//将指定字符串链接到此字符串的结尾，等价于用“+”
        System.out.println(str1);

        String str2 = "abc";
        String str3 = "aAb";
        System.out.println(str2.compareTo(str3));//比较两个字符串的大小
        System.out.println(str2.compareToIgnoreCase(str3));//与compareTo相同但是忽略大小写
        //涉及到字符串排序
        //该方法用于两个相同数据类型的比较，两个不同类型的数据不能用此方法来比较。

        String str4 = "锄禾日当午";
        System.out.println(str4.substring(2));//返回一个新的字符串，它是字符串从beginIndex开始截取到最后的一个子字符串。
        System.out.println(str4.substring(1,3));//返回一个新的字符串，它是字符串从beginIndex开始截取到endIndex(不包含)的子字符串。
        System.out.println(str4);

    }
}
