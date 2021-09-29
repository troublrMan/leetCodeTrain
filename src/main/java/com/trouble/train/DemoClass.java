package com.trouble.train;

/**
 * @author troubleMan
 * @description dem方法
 * @Date 2021/6/16 5:55 下午
 * @Version 1.0
 **/
public class DemoClass {

    public static void main(String[] args) {
        int [] array = {33, 22, 1, 4, 25, 88, 71, 4};
        insertionSort(array);
    }
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
            System.out.println(array);
        }
    }

    /**
     * 打印数组
     * @param array
     */
    private static void print(int[] array) {
        for(int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
