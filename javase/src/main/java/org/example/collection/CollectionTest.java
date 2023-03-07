package org.example.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author liuliangqi
 * @date 2023/3/6 16:43
 */
public class CollectionTest {
  // 这是一个main方法，是程序的入口：
  public static void main(String[] args) {
    /*
    Collection接口的常用方法:
    增加:add(E e) addAll(Collection<? extends E> c)
    删除:clear() remove(Object o)
    修改:
    查看:iterator() size()
    判断:contains(Object o)  equals(Object o)  isEmpty()
    */
    // 创建对象:接口不能创建对象,利用它的实现类创建对象
    Collection col = new ArrayList();
    // 调用方法:
    // 集合有一个特点:只能存放引用数据类型的数据,不能存放基本数据类型
    // 基本数据类型自动装箱,对应包装类.int--->Integer
    col.add(18);
    col.add(12);
    col.add(11);
    col.add(17);
    System.out.println(col /*.toString()*/); // [18, 12, 11, 17]

    List list = Arrays.asList(new Integer[] {11, 15, 3, 7, 1});
    col.addAll(list); // 将另一个集合添加入col中
    System.out.println(col); // [18, 12, 11, 17, 11, 15, 3, 7, 1]

    //        col.clear();//清空集合
    //        System.out.println(col);//[]
    System.out.println("集合的数量是:" + col.size());
    System.out.println("集合是否为空:" + col.isEmpty());

    boolean isRemove = col.remove(15);
    System.out.println(col);
    System.out.println("集合中的数据是否被删除:" + isRemove);

    Collection col2 = new ArrayList();
    col2.add(18);
    col2.add(12);
    col2.add(11);
    col2.add(17);

    Collection col3 = new ArrayList();
    col3.add(18);
    col3.add(12);
    col3.add(11);
    col3.add(17);

    System.out.println(col2.equals(col3));
    System.out.println(col2 == col3); // 比较的是地址值,一定不相等.  false

    System.out.println("集合中是否包含元素:" + col3.contains(17));
  }
}
