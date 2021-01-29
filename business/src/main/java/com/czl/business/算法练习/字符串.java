package com.czl.business.算法练习;


import java.util.ArrayList;
import java.util.List;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2021-01-24
 * @创建时间: 0:07
 */
class 字符串 {

    public static void main(String[] args) {
        最长回文("aabbaa");
        不含重复("abcassdasd");
        System.out.println(数字翻转(1234));

        String a[] = new String[]{"asd", "asdf", "as"};
        System.out.println(最长公共前缀(a));

        System.out.println(maxAre(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea1(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * 3,3
     * 2,2 2,3
     * 1,1 1,2,1,3
     *
     * @param s
     */
    public static void 最长回文(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        String result = "";
        for (int j = n - 1; j >= 0; j--) {

            for (int i = j; i < n; i++) {
                if (i == j) {
                    dp[j][i] = true;
                } else if (i == j + 1) {
                    dp[j][i] = s.charAt(j) == s.charAt(i);
                } else {

                    dp[j][i] = dp[j + 1][i - 1] && s.charAt(j) == s.charAt(i);
                }
                if (dp[j][i] && i + 1 - j > result.length()) {
                    result = s.substring(j, i + 1);
                }

            }
        }
        System.out.println(result);
    }

    public static void 不含重复(String s) {

        List list = new ArrayList<>();//
        int start = 0;
        int end = 0;
        int res = 0;
        while (start < s.length() && end < s.length()) {
            if (list.contains(s.charAt(end))) {
                list.remove(0);
                start++;
            } else {
                list.add(s.charAt(end));
                end++;
                res = Math.max(res, end - start);//同时记录当前最大长度
            }

        }

        System.out.println(res);

    }

    public static Integer 数字翻转(Integer s) {
        boolean flat = false;
        if (s < 0) {
            s = s * -1;
            flat = true;
        }
        char[] chars = String.valueOf(s).toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char c = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = c;
        }
        StringBuilder builder = new StringBuilder();
        for (char aChar : chars) {
            builder.append(aChar);
        }
        return flat ? -Integer.valueOf(builder.toString()) : Integer.valueOf(builder.toString());

    }

    public static String 最长公共前缀(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs == null) {
            return "";
        }

        int size = 200;
        for (String str : strs) {
            size = Math.min(str.length(), size);
        }

        if (size == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    return result.toString();
                }
            }
            result.append(strs[0].charAt(i));
        }
        return result.toString();

    }

    /**
     * 容纳最多的水
     *
     * @param height
     * @return
     */
    public static int maxAre(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int minHeight = 0;
            for (int j = height.length - 1; j > i; j--) {
                minHeight = Math.min(height[i], height[j]);
                max = Math.max(max, (j - i) * minHeight);
            }
        }
        return max;
    }

    /**
     * 容纳最多的水
     *
     * @param height
     * @return
     */
    public static int maxArea1(int[] height) {

        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

}
