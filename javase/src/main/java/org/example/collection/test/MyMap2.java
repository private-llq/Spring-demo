package org.example.collection.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuliangqi
 * @date 2023/3/10 16:44
 */
public class MyMap2 {
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    // V put(K key,V value)                  添加元素
    // 如果添加的键不存在，那么会把键值对都添加到集合中
    // 如果要添加的键存在，那么会覆盖原先的值，把原先值当作返回值进行返回
    map.put("001", "小明");
    map.put("002", "李华");
    map.put("003", "小红");
    map.put("004", "小美");
    map.put("005", "小黑");

    // int size()                            集合的长度，也就是集合中键值对的个数
    int size = map.size();
    System.out.println(size);
  }
}
