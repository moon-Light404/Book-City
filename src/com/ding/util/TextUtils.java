package com.ding.util;

public class TextUtils {
    /**
     * 判断一个字符串是否为空
     * @param s
     * @return
     */
    public static boolean isEmpty(CharSequence s){
        return s==null || s.length() == 0;
    }
}