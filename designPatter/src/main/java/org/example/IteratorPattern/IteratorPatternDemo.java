package org.example.IteratorPattern;

/**
 * @description: 迭代器模式
 * 使用 NameRepository 来获取迭代器，并打印名字。
 * @author liulq
 */
public class IteratorPatternDemo {
   
   public static void main(String[] args) {
      NameRepository namesRepository = new NameRepository();
 
      for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
         String name = (String)iter.next();
         System.out.println("Name : " + name);
      }  
   }
}