package org.example.collection.map;

import java.util.TreeMap;

/**
 * @author liuliangqi
 * @date 2023/3/16 18:20
 * TreeMap  自然排序
 */
public class TreeMapTest01 {
  public static void main(String[] args) {
    TreeMap<String, Integer> map = new TreeMap<>();
    map.put("3", 1);
    map.put("2", 1);
    map.put("1", 1);
    print(map);
  }

  private static void print(TreeMap<String, Integer> map) {
    map.forEach((k, v) -> System.out.println(k + ":" + v));
  }
}
