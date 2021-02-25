package com.czl.business.算法练习;

/**
 * 数学计算
 *
 * @author czlin
 * @date 2021-02-22 11:30
 */
public class 数学 {

    public static void main(String[] args) {
        System.out.println(power(2, -1));
        System.out.println(Add(1, 3));
        int[][] ints = new int[][]{{}};
        System.out.println(find(16, ints));
    }


    /**
     * 计算base的exponent次方
     *
     * @param base
     * @param exponent
     * @return
     */
    public static double power(double base, int exponent) {
        if (base == 0.0) {
            return 0.0;
        }

        double result = 1.0d;

        int e = exponent > 0 ? exponent : -exponent;

        for (int i = 1; i <= e; i++) {
            result *= base;
        }

        return exponent > 0 ? result : 1 / result;
    }

    /**
     * 不用加减乘除做加法
     *
     * @param num1
     * @param num2
     * @return
     */
    public static int Add(int num1, int num2) {
        //两个数异或：相当于每一位相加，而不考虑进位；
        //两个数相与，并左移一位：相当于求得进位；
        //将上述两步的结果相加
        while (num2 != 0) {
            int sum = num1 ^ num2;
            int carray = (num1 & num2) << 1;
            num1 = sum;
            num2 = carray;
        }
        return num1;
    }


    /**
     * 二维数组中查找是否存在
     *
     * @param target
     * @param array  从上到下递增，从左到右递增
     * @return
     */
    public static boolean find(int target, int[][] array) {
        if (array.length == 0) {
            return false;
        }
        if (array[0].length == 0) {
            return false;
        }

        int l = array.length;
        int w = array[0].length;
        if (array[0][0] > target) {
            return false;
        }
        if (array[l - 1][w - 1] < target) {
            return false;
        }

        int ww = 0;
        int ll = l - 1;
        while (ll >= 0 && ww <= w) {
            if (array[ll][ww] == target) {
                return true;
            }
            if (array[ll][ww] < target) {
                ww++;
            }
            if (array[ll][ww] > target) {
                ll--;
            }
        }

        return false;
    }



}
