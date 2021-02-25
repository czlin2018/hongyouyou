package com.czl.business.算法练习;

import java.util.Stack;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2021-02-21
 * @创建时间: 21:58
 */
public class 栈与队列 {

    public static void main(String[] args) {


        System.out.println(Solution.pop());
        Solution.push(1);
        Solution.push(2);
        Solution.push(3);
        System.out.println(Solution.pop());
        System.out.println(Solution.pop());
        Solution.push(4);
        System.out.println(Solution.pop());
        Solution.push(5);
        System.out.println(Solution.pop());
        System.out.println(Solution.pop());

    }


    /**
     * 两个栈实现队列
     */
    public static class Solution {
        static Stack<Integer> stack1 = new Stack<>();
        static Stack<Integer> stack2 = new Stack<>();

        static int pop() {
            if (!stack2.empty()) {
                return stack2.pop();
            }
            while (!stack1.empty()) {
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
            return stack2.empty() ? 0 : stack2.pop();
        }

        static void push(int node) {
            stack1.push(node);
        }
    }
}



