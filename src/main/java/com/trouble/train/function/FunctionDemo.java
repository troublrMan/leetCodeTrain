package com.trouble.train.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import javax.crypto.spec.PSource;
import org.springframework.http.converter.json.GsonBuilderUtils;

/**
 * * 图灵演算法 函数编程 *【数据+ 指令】函数是指令不可变 * 纳姆达演算法
 *
 * @author troubleMan
 * @description function
 * @Date 2022/12/9 00:30
 * @Version 1.0
 **/
public class FunctionDemo {


  // 姓名
  private String name;
  // 年龄
  private int age;
  // 性别
  private Gender gender;
  // 小区
  private Community community;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Community getCommunity() {
    return community;
  }

  public void setCommunity(Community community) {
    this.community = community;
  }

  public FunctionDemo(String name, int age, Gender gender, Community community) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.community = community;
  }


  static class Community {

    private String address;
    private String name;
    private int count; // 小区人数

    public String getAddress() {
      return address;
    }

    public void setAddress(String address) {
      this.address = address;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getCount() {
      return count;
    }

    public void setCount(int count) {
      this.count = count;
    }

    public Community(String address, String name, int count) {
      this.address = address;
      this.name = name;
      this.count = count;
    }
  }

  public enum Gender {
    MALE,
    FEMALE;
  }


  public static void main(String[] args) {
    Community hdb = new Community("黄渠头路", "海德堡", 2000);
    Community yglz = new Community("黄渠头路", "阳光丽兹", 1500);
    Community tdzy = new Community("黄渠头路", "唐顿庄园", 1000);
    Community qjld = new Community("雁翔路", "曲江龙邸", 1000);
    List<FunctionDemo> students = Arrays.asList(
        new FunctionDemo("小黑", 5, Gender.MALE, hdb),
        new FunctionDemo("小白", 6, Gender.FEMALE, hdb),
        new FunctionDemo("小红", 7, Gender.FEMALE, yglz),
        new FunctionDemo("小蓝", 5, Gender.MALE, tdzy),
        new FunctionDemo("小陈", 3, Gender.FEMALE, hdb),
        new FunctionDemo("小张", 3, Gender.MALE, yglz),
        new FunctionDemo("小吴", 5, Gender.MALE, hdb),
        new FunctionDemo("小刘", 12, Gender.FEMALE, hdb),
        new FunctionDemo("大牛", 16, Gender.MALE, qjld),
        new FunctionDemo("大李", 15, Gender.MALE, hdb),
        new FunctionDemo("大Q", 42, Gender.FEMALE, qjld),
        new FunctionDemo("大E", 35, Gender.MALE, hdb)
    );

    students.stream().mapToInt(FunctionDemo::getAge).map(age->age+10).forEach(System.out::println);

    // 或者or类型 。and 或者 or
//    students.stream().filter(new Predicate<FunctionDemo>() {
//          @Override
//          public boolean test(FunctionDemo functionDemo) {
//            return functionDemo.getAge() > 3;
//          }
//        }.and(new Predicate<FunctionDemo>() {
//          @Override
//          public boolean test(FunctionDemo functionDemo) {
//            return functionDemo.getGender().equals(Gender.FEMALE);
//          }
//        })
//    ).forEach(au -> System.out.println(au.getName() + au.getGender()));
//
//    students.stream().filter(new Predicate<FunctionDemo>() {
//      @Override
//      public boolean test(FunctionDemo functionDemo) {
//        return functionDemo.getAge() > 3 && functionDemo.getGender().equals(Gender.FEMALE);
//      }
//    }).forEach(au -> System.out.println(au.getName() + au.getGender()));


    test2(value -> value % 2 == 0, value -> value >4);


  }

  public static void test2(IntPredicate predicate1, IntPredicate predicate) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7,8,9,10};
    for (int i : arr) {
      if (predicate1.and(predicate).test(i)) {
        System.out.print(i);

      }

    }

  }


}

