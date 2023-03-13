package org.example.collection.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuliangqi
 * @date 2023/3/8 11:02
 */
public class Test01 {
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();

    map.put("001", "小明");
    map.put("002", "李华");
    map.put("003", "小红");

    System.out.println(map);
  }
}
