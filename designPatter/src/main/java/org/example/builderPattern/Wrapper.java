package org.example.builderPattern;

/**
 * @author liulq
 * 创建实现 Packing (包) 接口的实体类
 */
public class Wrapper implements Packing {
 
   @Override
   public String pack() {
      return "Wrapper";
   }
}