package com.trouble.train.cache.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author troubleMan
 * @description guava测试
 * @Date 2022/6/23 00:25
 * @Version 1.0
 **/
public class GuavaDemo {

  public static void guavaInit() {

  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    //缓存接口这里是LoadingCache，LoadingCache在缓存项不存在时可以自动加载缓存
    LoadingCache<Integer, User> studentCache
        //CacheBuilder的构造函数是私有的，只能通过其静态方法newBuilder()来获得CacheBuilder的实例
        = CacheBuilder.newBuilder()
        //设置并发级别为8，并发级别是指可以同时写缓存的线程数
        .concurrencyLevel(8)
        //设置写缓存后8秒钟过期
        .expireAfterWrite(8, TimeUnit.SECONDS)
        //设置缓存容器的初始容量为10
        .initialCapacity(10)
        //设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
        .maximumSize(100)
        //设置要统计缓存的命中率
        .recordStats()
        //设置缓存的移除通知
        .removalListener(new RemovalListener<Object, Object>() {
          @Override
          public void onRemoval(RemovalNotification<Object, Object> notification) {
            System.out.println(
                notification.getKey() + " was removed, cause is " + notification.getCause());
          }
        })
        //build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
        .build(
            new CacheLoader<Integer, User>() {
              @Override
              public User load(Integer key) throws Exception {
                System.out.println("load student " + key);
                User student = new User();
                student.setUserId(System.currentTimeMillis() + "");
                student.setUserName("name " + key);
                return student;
              }
            }
        );

    for (int i = 0; i < 20; i++) {
      //从缓存中得到数据，由于我们没有设置过缓存，所以需要通过CacheLoader加载缓存数据
      User student = studentCache.get(1);
      System.out.println(student);
      //休眠1秒
      TimeUnit.SECONDS.sleep(1);
    }

    System.out.println("cache stats:");
    //最后打印缓存的命中率等情况
    System.out.println(studentCache.stats().toString());

  }

}
