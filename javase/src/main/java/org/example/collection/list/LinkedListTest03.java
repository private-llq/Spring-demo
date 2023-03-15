package org.example.collection.list;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author liuliangqi
 * @date 2023/3/2 16:41
 */
public class LinkedListTest03 {
  public static void main(String[] args) {
    // 需求：使用 LinkedList 完成存储字符串并遍历
    LinkedList<String> list = new LinkedList<>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");

    System.out.println("--------普通for循环--------");
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }

    System.out.println("--------迭代器--------");
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    System.out.println("--------增强for循环--------");
    for (String s : list) {
      System.out.println(s);
    }
  }
}
