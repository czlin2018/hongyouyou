package com.czl.business.算法练习;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2021-01-24
 * @创建时间: 21:45
 */
public class 正则 {

    public static void main(String[] args) {
        匹配存在();
        提取();
        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
    }

    private static void 匹配存在() {
        String content = "I am noob from runoob.com.";
        String pattern = "[\\w ]*runoob.*";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println(content.matches(pattern));
        System.out.println(isMatch);


    }

    /**
     * 提取
     */
    private static void 提取() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("我的QQ是:456456 我的电话是:0532214 我的邮箱是:aaa123@aaa.com");
        while (m.find()) {
            System.out.println(m.group());
        }
    }


    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     *
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        String s = str.toString();
        String pattern = " ";
        return s.replaceAll(pattern, "%20");
    }

}
