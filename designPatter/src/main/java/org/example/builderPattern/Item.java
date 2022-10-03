package org.example.builderPattern;

/**
 * 创建一个表示食物条目和食物包装的接口。
 * @author liulq
 */
public interface Item {
   public String name();

   /**
    * 包装
    * @return Packing
    */
   public Packing packing();
   public float price();    
}