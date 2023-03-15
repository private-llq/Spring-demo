package org.example.collection.set;

import org.example.collection.Student;

import java.util.HashSet;

/**
 * @author liuliangqi
 * @date 2023/3/6 15:36
 */
public class HashSetTest1 {
  public static void main(String[] args) {
    // 测试HashSet
    HashSet<Student> hashSet = new HashSet<>(16);
    // 创建学生对象
    Student s1 = new Student("zhangsan", 23);
    Student s2 = new Student("lisi", 24);
    Student s3 = new Student("wanmgwu", 25);
    Student s4 = new Student("lisi", 24);
    // 把学生对象添加到集合
    hashSet.add(s1);
    hashSet.add(s2);
    hashSet.add(s3);
    hashSet.add(s4);
    // 遍历集合（增强for） 应该set不能存重复的数据，所以自动去重了  使用场景：去重、排序
    for (Student student : hashSet) {
      System.out.println("学生的值：" + student);
    }
  }
}
