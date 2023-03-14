package org.example.collection.test;

/**
 * @author liuliangqi
 * @date 2023/3/13 10:49 可变参数
 */
public class Test02 {
  /**
   * 需求：定义一个方法求N个数的和
   * 可变参数实现
   * @param args
   */
  public static void main(String[] args) {
    int sum = getSum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    System.out.println(sum);
  }

  public static int getSum(int number, int... arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    return sum;
  }
}
