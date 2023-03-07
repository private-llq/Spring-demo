package org.example.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author liuliangqi
 * @date 2023/3/6 16:48
 */
public class CollectionTest01 {
  // 这是一个main方法，是程序的入口：
  public static void main(String[] args) {
    Collection col = new ArrayList();
    col.add(18);
    col.add(12);
    col.add(11);
    col.add(17);
    col.add("abc");
    col.add(9.8);
    // 对集合遍历（对集合中元素进行查看）
    // 方式1：普通for循环(无法使用)
    /*for(int i= 0;i<col.size();i++){
        col.
    }*/
    // 方式2：增强for循环
    for (Object o : col) {
      System.out.println(o);
    }
    System.out.println("------------------------");
    // 方式3：iterator()
    Iterator it = col.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }
}
