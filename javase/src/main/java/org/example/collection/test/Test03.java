package org.example.collection.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liuliangqi
 * @date 2023/3/15 9:13
 * 创建不可变集合
 */
public class Test03 {
  public static void main(String[] args) {
      ArrayList<Object> list = new ArrayList<>(10);
      list.add(1);
      list.add(2);
      list.add(3);
      list.add(1);
      List<Object> objects = Collections.unmodifiableList(list);
      objects.add(3);
    System.out.println(objects);
  }
}
