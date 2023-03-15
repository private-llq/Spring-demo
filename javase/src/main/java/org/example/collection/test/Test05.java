package org.example.collection.test;

/**
 * @author liuliangqi
 * @date 2023/3/15 14:44 可变参数
 */
public class Test05 {
  public static void main(String[] args) {
    printNumbers("1", "2", "3"); // 输出1 2 3
  }

  public static void printNumbers(String... numbers) {
    for (String number : numbers) {
      System.out.println(number);
    }
  }
}
