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
        System.out.println(num1 << 1);
        System.out.println(num1 >> 1);
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


}
