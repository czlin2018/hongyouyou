package com.czl.business.算法练习;


/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2021-01-24
 * @创建时间: 0:07
 */
class 动态规划 {

    public static void main(String[] args) {

        System.out.println(Fibonacci1(4));
        System.out.println(Fibonacci2(4));
        int 爬楼梯1 = 爬楼梯1(10);
        System.out.println(爬楼梯1);
        int 爬楼梯2 = 爬楼梯2(10);
        System.out.println(爬楼梯2);
        int 爬楼梯3 = 爬楼梯3(10);
        System.out.println(爬楼梯3);
    }


    /**
     * 斐波那契数列
     * 递归
     *
     * @param n
     * @return
     */
    private static int Fibonacci1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci1(n - 1) + Fibonacci1(n - 2);
    }

    /**
     * 斐波那契数列
     * 动态规划
     *
     * @param n
     * @return
     */
    private static int Fibonacci2(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];

    }

    /**
     * 爬楼梯问题：n阶楼梯，可选择一次走一步，可以选择一次走两步，到达n阶有多少种方案
     * 递归
     */
    private static int 爬楼梯1(int sumOfStairs) {
        //动态规范
        //子问题：f(n)
        //状态转移方程：f(n)=f(n-1)+f(n-2)+2
        if (sumOfStairs == 1) {
            return 1;
        }
        if (sumOfStairs == 2) {
            return 2;
        }
        return 爬楼梯1(sumOfStairs - 1) + 爬楼梯1(sumOfStairs - 2);
    }

    /**
     * 爬楼梯问题：n阶楼梯，可选择一次走一步，可以选择一次走两步，到达n阶有多少种方案
     * 中间数组
     */
    private static int 爬楼梯2(int sumOfStairs) {
        int[] sum = new int[sumOfStairs + 1];
        return 爬(sumOfStairs, sum);
    }

    private static int 爬(int sumOfStairs, int[] sum) {
        if (sumOfStairs == 1) {
            return 1;
        }
        if (sumOfStairs == 2) {
            return 2;
        }
        if (sum[sumOfStairs] != 0) {
            return sum[sumOfStairs];
        }
        int i = 爬楼梯2(sumOfStairs - 1) + 爬楼梯2(sumOfStairs - 2);
        sum[sumOfStairs] = i;
        return i;
    }


    /**
     * 爬楼梯问题：n阶楼梯，可选择一次走一步，可以选择一次走两步，到达n阶有多少种方案
     * 动态规范
     */
    private static int 爬楼梯3(int sumOfStairs) {
        int[] sum = new int[sumOfStairs + 1];
        sum[1] = 1;
        sum[2] = 2;
        for (int i = 3; i <= sumOfStairs; i++) {
            sum[i] = sum[i - 1] + sum[i - 2];
        }
        return sum[sumOfStairs];
    }


}