package org.example.strategyPattern;

/**
 * @author liulq
 * @description: 实现接口
 */
public class OperationMultiply implements Strategy{
   @Override
   public int doOperation(int num1, int num2) {
      return num1 * num2;
   }
}