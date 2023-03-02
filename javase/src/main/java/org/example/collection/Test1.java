package org.example.collection;

import java.util.LinkedList;

/**
 * @author liuliangqi
 * @date 2023/2/24 17:05
 */
public class Test1 {
  Test model;

  private void test() {
    model.test(1);
  }

  public static void main(String[] args) {
    Dept dept = new Dept();
    dept.setDeptno(1L);
    dept.setDname("llq");
    LinkedList<Object> linkedList1 = new LinkedList<>();
    linkedList1.add(dept);
    linkedList1.add(123);
    // 浅拷贝
    LinkedList clone = (LinkedList) linkedList1.clone();
    System.out.println("浅拷贝之前的值：" + linkedList1);
    System.out.println("浅拷贝之后的值：" + clone);
    System.out.println("两者对比：" + (clone == linkedList1));

    // 对象中的元素对比
    System.out.println("两者中的对象实例对比：" + (clone.get(0) == linkedList1.get(0)));
    System.out.println(clone.get(0));
    System.out.println(linkedList1.get(0));




  }
}
