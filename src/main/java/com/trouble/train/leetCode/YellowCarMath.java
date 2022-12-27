package com.trouble.train.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author troubleMan
 * @description 小黄车问题
 * @Date 2022/11/11 15:32
 * @Version 1.0
 **/
public class YellowCarMath {

  /**
   * 1、 地图上有三个地铁站，A 地铁站初始存放 30 辆小黄车，B 地铁站初始存放 40 辆小黄车，C 地铁站初 始 30 2、 有两辆货车持续在 A 站、B 站和 C站之间运输，货车最大满载
   * 20 辆小黄车。每秒能移动 3 个格子距 离， 路线随机；货车运输小黄车（装卸时间不计），确保三个地铁站小黄车足够满足乘客需求。 3、 每秒钟会有一个乘客会在A、B、C
   * 站之间使用小黄车骑行，路线随机，每秒只能骑行 1 个格子距 离。
   */


  public static volatile Integer carNum = 2;

  public static volatile Integer A = 30;
  public static volatile Integer B = 40;
  public static volatile Integer C = 30;
  public static HashMap<String, Integer> map = new HashMap<>();

  static {
    map.put("A", A);
    map.put("B", B);
    map.put("C", C);
  }


  public static Integer AC = 6;
  public static Integer AB = 15;
  public static Integer BC = 9;
  public static Integer CA = 6;
  public static Integer BA = 15;
  public static Integer CB = 9;

  public static HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();

  static {
    stringIntegerHashMap.put("AC", AC);
    stringIntegerHashMap.put("AB", AB);
    stringIntegerHashMap.put("BC", BC);

    stringIntegerHashMap.put("CA", CA);
    stringIntegerHashMap.put("BA", BA);
    stringIntegerHashMap.put("CB", CB);
  }


  public static List<YellowCarDTO> list = new ArrayList<>();

  public static String[] ints = new String[]{"A", "B", "C"};

  // 初始位置
  public static List<String> listCar = new ArrayList<>();

  static {
    listCar.add("A");
    listCar.add("A");
  }

  private static void doRunInvoke(StringBuffer stringBuffer) {
    for (YellowCarDTO car : list) {
      Integer mileage = car.getMileage();
      String type = car.getType();
      if (Objects.equals(type, "car")) {
        mileage = mileage - 1;
      } else if (Objects.equals(type, "cycling")) {
        mileage = mileage - 3;
      }
      if (mileage <= 0) {
        car.setMileage(mileage);
        if (Objects.equals(type, "cycling")) {
          carNum = carNum + 1;
          //并且记录可发车位置
          listCar.add(car.getTager());
        }
        String tager = car.getTager();
        map.put(tager, map.get(tager) + car.getSum());
      } else {
        car.setMileage(mileage);

        if (Objects.equals(type, "cycling")) {
          stringBuffer.append(car.getStart() + "到" + car.getTager() + "运输" + car.getSum() + "辆车 ");
        }
      }
    }

    list = list.stream().filter(l -> !Objects.equals(l.getMileage(), 0))
        .collect(Collectors.toList());
  }

  /**
   * 生成运输任务
   */
  private static void creatTaskCar() {
    if (carNum <= 0) {
      return;
    }
    if (!Utils.getRandom()) {
      return;
    }
    String[] objects = listCar.toArray(new String[listCar.size()]);
    // 起始位置
    String random = Utils.getRandom(objects, 1);
    // 终点
    String randomEnd = Utils.getRandomEnd(random, ints, 2);

    int random1 = Utils.getRandom(20);

    Integer integer = map.get(random);
    if (integer < random1) {
      // 车辆数据不够无法调用
      return;
    }
    carNum -= 1;
    String s = new StringBuffer().append(random).append(randomEnd).toString();
    Integer integer1 = stringIntegerHashMap.get(s);

    YellowCarDTO carDTO = new YellowCarDTO();
    carDTO.setStart(random);
    carDTO.setTager(randomEnd);
    carDTO.setType("cycling");
    carDTO.setMileage(integer1);
    carDTO.setSum(random1);

    map.put(random, integer - random1);

    list.add(carDTO);

    listCar.remove(random);

  }

  /**
   * 骑行任务
   */
  private static void creatCyclingTask() {
    // 起始点
    String random = Utils.getRandom(ints, 2);
    if (map.get(random) > 0) {
      // 终点
      String randomRoute = Utils.getRandomEnd(random, ints, 2);

      Integer integer = stringIntegerHashMap
          .get(new StringBuffer().append(random).append(randomRoute).toString());
      if (integer != null && integer > 0) {
        YellowCarDTO carDTO = new YellowCarDTO();
        carDTO.setTager(randomRoute);
        carDTO.setType("car");
        carDTO.setMileage(integer);
        Integer integer1 = map.get(random);
        map.put(random, integer1 - 1);
        list.add(carDTO);
      }
    }
  }

  public static String getStringBuffer(StringBuffer stringBuffer) {
    Set<Entry<String, Integer>> entries = map.entrySet();
    Integer temp = 0;
    for (Map.Entry<String, Integer> entry : entries) {
      String key = entry.getKey();
      Integer value = entry.getValue();
      stringBuffer.append(key + "车站" + value + ",");
      temp += value;
    }

    if (temp < 100) {
      stringBuffer.append("路上车为" + (100 - temp));
    }
    return stringBuffer.toString();
  }

  /**
   * 时间类型的format
   * @param time
   * @return
   */
  public static String getVideoFormat(long time) {
    int temp = (int) time;
    int hh = temp / 3600;
    int mm = (temp % 3600) / 60;
    int ss = (temp % 3600) % 60;
    return (hh < 10 ? ("0" + hh) : hh) + ":" +
        (mm < 10 ? ("0" + mm) : mm) + ":" +
        (ss < 10 ? ("0" + ss) : ss);
  }

  public static void main(String[] args) {
    StringBuffer stringBuffer = new StringBuffer();

    getStringBuffer(stringBuffer);
    System.out.println("00:00:00" + stringBuffer);

    int second = 1;
    int maxSize = 200;
    while (second <= maxSize) {
      System.out.print(getVideoFormat(second)+"秒");
      stringBuffer = new StringBuffer();
      // 运行一秒
      doRunInvoke(stringBuffer);

      creatCyclingTask();
      creatTaskCar();

      String stringBuffer1 = getStringBuffer(stringBuffer);
      System.out.println(stringBuffer1);
      second ++;
    }

  }
}
