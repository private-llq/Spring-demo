package org.example.collection;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuliangqi
 * @date 2023/3/2 18:01
 */
public class HashSetTest {
  public static void main(String[] args) {
    // HashSet
    HashSet<Object> hashSet = new HashSet<>(16);
    hashSet.add(8);
    hashSet.add(2);
    hashSet.add(1);
    hashSet.add(5);
    // 可以自动排序
    System.out.println("结果：" + hashSet);

    Map<Object, Object> hashMap = new HashMap<>(16);
    hashMap.put("llq", 8);
    hashMap.put("llq", 2);
    hashMap.put("llq", 1);
    hashMap.put("llq", 5);
    for (Object entry : hashMap.keySet()) {
      System.out.println(hashMap.get(entry));
    }
    System.out.println(hashMap.entrySet().stream().collect(Collectors.toList()));
  }
}
