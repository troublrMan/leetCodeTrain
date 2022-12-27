package com.trouble.train.groovy;

import groovy.lang.GroovyClassLoader;

/**
 * @author troubleMan
 * @description groovy 工厂类
 * @Date 2022/12/6 23:32
 * @Version 1.0
 **/
public class GroovyFactory {

  private static GroovyFactory groovyFactory = new GroovyFactory();
  private GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
  private static volatile GroovyFactory singleton = null;

  public static GroovyFactory getInstance() {
    if (singleton == null) {
      synchronized (GroovyFactory.class) {
        if (singleton == null) {
          singleton = new GroovyFactory();
        }
      }
    }
    return singleton;
  }

  /**
   * 执行模式
   */



}
