package org.example.segregation;


/**
 * @program: spring-demo
 * @description: 单例模式- 懒加载，线程不安全
 * @author: liulq
 * @create: 2022-10-02 10:43
 */
public class SingletonLazy {

  private SingletonLazy(){}
  private static SingletonLazy instance;
  public synchronized static SingletonLazy getInstance(){
      //判断对象为null 的时候在创建对象
      if (instance == null) {
          System.out.println("创建了一个空单例");
          instance=new SingletonLazy();
      }
      return instance;
  }

    public static void main(String[] args) {
        System.out.println(getInstance());

        //利用多线程破坏单例
        for(int i = 0; i <3;i++){
            new Thread(()->{
                System.out.println("多线程创建单例："+SingletonLazy.getInstance());
            }).start();
        }
    }



}
