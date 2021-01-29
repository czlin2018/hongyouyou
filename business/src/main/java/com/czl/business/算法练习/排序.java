package com.czl.business.算法练习;

import java.util.Arrays;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2021-01-24
 * @创建时间: 23:15
 */
public class 排序 {
    public static void main(String[] args) {
        int[] data = new int[]{4, 6, 2, 3, 7, 1, 2, 3, 4, 5};
//        傻冒泡(data);
//        冒泡(data);
        快速排序(data, 0, data.length - 1);
        Arrays.stream(data).forEach(System.out::print);
    }

    private static void 傻冒泡(int[] data) {
        int length = data.length;
        if (length == 0) {
            return;
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (data[i] > data[j]) {
                    int datum = data[i];
                    data[i] = data[j];
                    data[j] = datum;
                }
            }
        }
        Arrays.stream(data).forEach(System.out::print);
        System.out.println("");
    }

    private static void 冒泡(int[] data) {
        int length = data.length;
        if (length == 0) {
            return;
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int datum = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = datum;
                }
            }
        }

        Arrays.stream(data).forEach(System.out::print);
    }


    static void 快速排序(int array[], int low, int high) {
        if (low < high) {
            int i = low;
            int j = high;
            int key = array[i];
            while (i < j) {
                while (i < j && array[j] >= key) {
                    j--;
                }
                array[i] = array[j];
                while (i < j && array[i] <= key) {
                    i++;
                }
                array[j] = array[i];
            }
            array[i] = key;
            快速排序(array, low, i - 1);
            快速排序(array, i + 1, high);
        }
    }




}
