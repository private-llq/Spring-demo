package org.example.collection.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author liuliangqi
 * @date 2023/3/15 16:50
 */
public class TreeMapTest {
  // 这是一个main方法，是程序的入口：
  public static void main(String[] args) {
    Map<String, Integer> map = new TreeMap<>();
    map.put("blili", 1234);
    map.put("alili", 2345);
    map.put("blili", 5467);
    map.put("clili", 5678);
    map.put("dlili", 2345);
    System.out.println(map.size());
    System.out.println(map);
  }
}
