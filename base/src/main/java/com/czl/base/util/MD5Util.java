package com.czl.base.util;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 */
public class MD5Util {

    private MD5Util () {
    }

    private static MessageDigest getMd5() throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("MD5");
    }

    private static char digits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * MD5 加密，结果为小写的16进制。
     */
    public static String encript(byte[] byteArr) {
        MessageDigest md5;
        try {
            md5 = getMd5();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
        md5.update(byteArr);
        return Hex.encodeHexString(md5.digest());
    }

    /**
     * MD5 加密，并转为大写的16进制。
     */
    public static String encrypt(String str) {
        return encript(str.getBytes()).toLowerCase();
    }

    public static String encode(String s) {
        if (null == s) {
            return "";
        }

        try {
            byte[] bytes = s.getBytes();
            getMd5().update(bytes);
            byte[] md = getMd5().digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = digits[byte0 >>> 4 & 0xf];
                str[k++] = digits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
