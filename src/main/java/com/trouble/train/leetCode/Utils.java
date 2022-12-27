package com.trouble.train.leetCode;

import java.util.Objects;
import java.util.Random;

/**
 * @author troubleMan
 * @description 工具类
 * @Date 2022/11/11 16:00
 * @Version 1.0
 **/
public class Utils {

  public static Boolean getRandom() {
    Random rand = new Random();
    return rand.nextBoolean();
  }

  public static int getRandom(int a) {
    Random rand = new Random();
    return rand.nextInt(a);
  }

  /**
   * 获取起始点
   *
   * @return
   */
  public static String getRandom(String[] b, int a) {
    Random rand = new Random();
    int num = rand.nextInt(a);
    return b[num];
  }

  /**
   * 获取终点
   * @param random
   * @param b
   * @param a
   * @return
   */
  public static String getRandomEnd(String random, String[] b, int a) {

    String temp = getRandom(b, a);
    while (Objects.equals(random, temp)) {
      temp = getRandom(b, a);
    }
    return temp;
  }


}
