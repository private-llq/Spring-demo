package org.example.collection.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author liuliangqi
 * @date 2023/3/10 18:03
 */
public class MyMap4 {
  public static void main(String[] args) {
    // 创建集合并添加元素
    Map<String, String> map = new HashMap<>();
    map.put("001", "小明");
    map.put("002", "李华");
    map.put("003", "小红");
    map.put("004", "小美");
    map.put("005", "小黑");

    // 获取所有的键值对对象
    // Set集合中装的是键值对对象（Entry对象）
    // 而Entry里面装的是键和值
    Set<Map.Entry<String, String>> entries = map.entrySet();
    for (Map.Entry<String, String> entry : entries) {
      // 得到每一个键值对对象
      String key = entry.getKey();
      String value = entry.getValue();
      System.out.println(key + "----" + value);
    }
  }
}
