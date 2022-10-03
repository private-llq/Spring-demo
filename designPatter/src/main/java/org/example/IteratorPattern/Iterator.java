package org.example.IteratorPattern;

/**
 * @author liulq
 */
public interface Iterator {
   /**
    * 当前值
    * @return boolean
    */
   public boolean hasNext();

   /**
    * 下一个
    * @return Object
    */
   public Object next();
}