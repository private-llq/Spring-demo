package org.example.strategyPattern;

/**
 * @author liulq
 */
public interface Strategy {
   /**
    * 定义一个接口
    * @param num1
    * @param num2
    * @return int
    */
   public int doOperation(int num1, int num2);
}