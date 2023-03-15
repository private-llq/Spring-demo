package org.example.collection.set;

import org.example.collection.Student;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author liuliangqi
 * @date 2023/3/6 15:43
 */
public class HashSetDemo1 {
  public static void main(String[] args) {
    HashSet<String> hs = new HashSet<>();
    // 添加元素
    hs.add("hello");
    hs.add("world");
    hs.add("java");
    hs.add("java");
    hs.add("java");
    hs.add("java");
    hs.add("java");
    // 遍历集合
    System.out.println("-------迭代器遍历-------");
    Iterator<String> iterator = hs.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    System.out.println("-------增强for遍历-------");
    for (String h : hs) {
      System.out.println(h);
    }


    Student s1 = new Student("zhangsan", 23);
    Student s2 = new Student("lisi", 24);

    // 因为在Object类中，是根据对象的地址值计算出来的哈希值
    System.out.println(s1.hashCode()); // 1060830840
    System.out.println(s1.hashCode()); // 1060830840
    System.out.println(s2.hashCode()); // 2137211482
  }
}
