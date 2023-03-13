package org.example.collection.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author liuliangqi
 * @date 2023/3/10 17:32
 */
public class MyMap3 {
  public static void main(String[] args) {
    // 创建集合并添加元素
    Map<String, String> map = new HashMap<>();
    map.put("001", "小明");
    map.put("002", "李华");
    map.put("003", "小红");
    map.put("004", "小美");
    map.put("005", "小黑");
    // 获取所有的键
    Set<String> keys = map.keySet();
    // 遍历Set集合得到每一个键
    for (String key : keys) {
      // 通过每一个键key，来获取对应的值
      String value = map.get(key);
      System.out.println(key + "----" + value);
    }
  }
}
