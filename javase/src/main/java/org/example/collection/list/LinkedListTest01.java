package org.example.collection.list;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author liuliangqi
 * @date 2023/3/2 15:54
 */
public class LinkedListTest01 {
  public static void main(String[] args) {
    // 使用泛型LinkedList集合
    LinkedList<String> books = new LinkedList<>();
    // 在队尾添加元素
    books.offer("java");
    // 在队头添加元素(入栈)
    books.push("java SE");
    // 在队头添加元素（入队）
    books.offerFirst("C语言");
    // 在队尾添加元素()
    books.offerLast("C++语言");

    // 直接输出
    System.out.println(books);
    System.out.println("--------------------");

    // 用foreach循环来遍历
    System.out.println("foreach循环来遍历:");
    for (String str : books) {
      System.out.println(str);
    }
    System.out.println("--------------------");

    System.out.println("按索引来访问遍历：");
    // 以List的方式来遍历集合元素
    for (int i = 0; i < books.size(); ++i) {
      System.out.println(books.get(i));
    }
    System.out.println("--------------------");

    // 访问不删除栈顶元素
    System.out.println("peekFirst:" + books.peekFirst());
    // 访问不删除元素最后一个元素
    System.out.println("peekLask:" + books.peekLast());
    // 将栈顶的元素弹出栈
    System.out.println("pop:" + books.pop());
    // 访问并删除队列的最后一个元素
    System.out.println("pollLast:" + books.pollLast());
    System.out.println("--------------------");

    System.out.println("删除后的剩下的数据：");
    // 获取Linkedlist的迭代器
    Iterator<String> iterator = books.iterator();
    while (iterator.hasNext()) { // 是否有下一个
      System.out.println(iterator.next()); // 返回下一个
    }
  }
}
