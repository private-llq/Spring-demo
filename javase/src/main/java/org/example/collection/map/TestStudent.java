package org.example.collection.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author liuliangqi
 * @date 2023/3/15 17:41
 */
public class TestStudent {
  public static void main(String[] args) {
    Map<Student, Integer> map = new TreeMap<>();
    map.put(new Student(19, "lili", 170.5), 1001);
    map.put(new Student(18, "blili", 150.5), 1003);
    map.put(new Student(19, "alili", 180.5), 1023);
    map.put(new Student(17, "clili", 140.5), 1671);
    map.put(new Student(10, "dlili", 160.5), 1891);
    System.out.println(map.size());
    System.out.println(map);
  }
}
