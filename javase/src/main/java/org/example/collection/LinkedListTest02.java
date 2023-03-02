package org.example.collection;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author liuliangqi
 * @date 2023/3/2 16:33
 */
public class LinkedListTest02 {
  // 这是一个main方法，是程序的入口：
  public static void main(String[] args) {
    /*
     * LinkedList的常用方法:
     * 增加:addFirst(E e) addLast(E e)
     *      offer(E e)  offerFirst(E e)  offerLast(E e)
     * 删除:poll()  pollFirst()  pollLast() --->>JDK1.6以后新出的方法，提高了代码的健壮性
     *      removeFirst()  removeLast()--->>早期版本,容易抛异常
     * 修改:
     * 查看:element()
     *      getFirst() getLast()
     *      indexOf(Object o)  lastIndexOf(Object o)
     *      peek()  peekFirst()  peekLast()
     * 判断:
     * */
    // 创建一个LinkedList集合的对象:
    LinkedList<String> list = new LinkedList<>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    list.add("eee");
    list.add("bbb");
    list.add("fff");
    // LinkedList可以添加重复数据
    System.out.println(list); // [aaa, bbb, ccc, ddd, eee, bbb, fff]
    // 添加元素在首尾
    list.addFirst("jj");
    list.addLast("hh");
    System.out.println(list); // [jj, aaa, bbb, ccc, ddd, eee, bbb, fff, hh]
    // 添加元素在尾端
    list.offer("kk");
    System.out.println(list); // [jj, aaa, bbb, ccc, ddd, eee, bbb, fff, hh, kk]
    // 添加元素在首尾
    list.offerFirst("pp");
    list.offerLast("rr");
    System.out.println(list); // [pp, jj, aaa, bbb, ccc, ddd, eee, bbb, fff, hh, kk, rr]
    // 删除首位元素并将该元素输出
    System.out.println(list.poll()); // pp
    // 删除首位元素并将该元素输出
    System.out.println(list.pollFirst()); // jj
    // 删除末位元素并将该元素输出
    System.out.println(list.pollLast()); // rr
    System.out.println(list.removeFirst()); // aaa
    System.out.println(list.removeLast()); // kk
    System.out.println(list);
    //        list.clear();//清空集合
    //        System.out.println(list);//[]
    //        System.out.println(list.pollFirst());
    //        System.out.println(list.removeFirst());//报错:Exception in thread "main"
    // java.util.NoSuchElementException

    // LinkedList集合的遍历:
    System.out.println("----------------------");
    // 普通for循环:
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
    System.out.println("----------------------");
    // 增强for循环:
    for (String s : list) {
      System.out.println(s);
    }
    System.out.println("----------------------");
    // 迭代器:
    /*Iterator<String> it = list.iterator();
    while (it.hasNext()){
        System.out.println(it.next());
    }*/
    // 相较于上一种方法,这种方法省内存
    for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
      System.out.println(it.next());
    }
  }
}
