package com.trouble.train.design;

/**
 * @author troubleMan
 * @description 单例模式
 * @Date 2022/7/19 23:13
 * @Version 1.0
 **/
public class Singleton {

  private static  Singleton instance;

   private Singleton(){

   }
   public static Singleton getInstance(){
     // 校验是否已经被实例化
     if (null != instance) {
       return instance;
     }
     // 加锁线程安全
     synchronized (Singleton.class) {
       // 双重校验
       if (instance == null) {
         return new Singleton();
       }
     }
     return instance;
   }

}
