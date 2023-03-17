package org.example.collection.map;

import java.util.*;

/**
 * @author llq
 * 去重
 */
public class ListDistinctExample {
  public static void main(String[] args) {
    List<Integer> list =
        new ArrayList<Integer>() {
          {
            add(1);
            add(3);
            add(5);
            add(2);
            add(1);
            add(3);
            add(7);
            add(2);
          }
        };
    System.out.println("原集合:" + list);
    method_1(list);

    Integer[] intArray1 = new Integer[2];
    List<Integer> list1 = Arrays.asList(intArray1);
    System.out.println(list1);
  }

  /**
   * 使用迭代器去重
   *
   * @param list
   */
  public static void method_1(List<Integer> list) {
    Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext()) {
      // 获取循环的值
      Integer item = iterator.next();
      // 如果存在两个相同的值
      if (list.indexOf(item) != list.lastIndexOf(item)) {
        // 移除最后那个相同的值
        iterator.remove();
      }
    }
    System.out.println("去重集合:" + list);
  }


  public List<String> removeStringListDupli(List<String> stringList) {
    Set<String> set = new LinkedHashSet<>();
    set.addAll(stringList);

    stringList.clear();

    stringList.addAll(set);
    return stringList;
  }
}
