package com.trouble.train;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author troubleMan
 * @description dem方法
 * @Date 2021/6/16 5:55 下午
 * @Version 1.0
 **/
public class DemoClass {

//    public static void main(String[] args) {
//        int [] array = {33, 22, 1, 4, 25, 88, 71, 4};
//        insertionSort(array);
//    }
    /**
     * 插入排序
     */
    private static void insertionSort(int[] array) {
        System.out.println();
        for (int i = 1; i <array.length; i++) {
            int j = i - 1;
            int value = array[i];
            for (; j >= 0; j--) {
                if (array[j] > value) {
                    array[j+1] = array[j];
                } else {
                    break;
                }
            }
            array[j+1] = value;
        }
        for(int i : array) {
            System.out.print(i + " ");
        }
    }

    /**
     * 打印数组

     */

    public static void main(String[] args) {
//        List<Student> students = new ArrayList<>(3);
//        students.add(new Student("路飞", 22, 175));
//        students.add(new Student("红发", 40, 180));
//        students.add(new Student("白胡子", 50, 185));
//
//        long count = students.stream().filter(s1 -> s1.getAge() < 45).count();
//        System.out.println("年龄小于45岁的人数是：" + count);
//
//        Integer reduce = Stream.of(1, 2, 3, 4).reduce(0, (acc, x) -> acc+ x);
//        System.out.println(reduce);


        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));

        String names = students.stream()
                .map(Student::getName).collect(Collectors.joining(",","[","]"));
        System.out.println(names);
    }
    private static void print(int[] array) {



    }

    static class Student{
        String name;
        Integer age;
        Integer hight;

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Integer getHight() {
            return hight;
        }

        public Student(String name, Integer age, Integer hight) {
            this.name = name;
            this.age = age;
            this.hight = hight;
        }
    }
}

