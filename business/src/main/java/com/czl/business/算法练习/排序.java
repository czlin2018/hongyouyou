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
        int[] data = new int[]{1, 9, 7, 3, 4, 6, 2, 5, 8};
        冒泡(data);
    }

    private static void 冒泡(int[] data) {
        if (data.length == 0) {
            return;
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j + 1] < data[j]) {
                    int temp = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = temp;
                }
            }
        }
        Arrays.stream(data).forEach(System.out::print);
    }


}
