package org.example.strategyPattern;

/**
 * @author liulq
 */
public class Context {
   //定义Strategy接口
   private Strategy strategy;

   //返回接口
   public Context(Strategy strategy){
      this.strategy = strategy;
   }
   //返回接口里面定义的方法
   public int executeStrategy(int num1, int num2){
      return strategy.doOperation(num1, num2);
   }



}