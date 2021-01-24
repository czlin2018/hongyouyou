package com.czl.business.算法练习;

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
        String content = "I am noob from runoob.com.";
        //        String pattern = ".*runoob.*";
        String pattern = "[\\w ]*runoob.*";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }
    //.匹配出了换行/t/n之外的数据
    //w 匹配[A-Za-z0-9]
}
