package com.zeroten.common.util;

public class CheckUtils {
    /*
     * 如果Strings中有任意一个字符串为空，则返回false，否则返回true。
     * */
    public static boolean isAnyEmpty(String...strings){
        for (int a = 0;a<strings.length;a++){
            if (strings[a].equals("")){
                return false;
            }
        }
        return true;
    }
    /*
    * 判断引⽤类型数组是否为空，为空或 null 则返回 true，否则返回 false。
     * */
    public  static  boolean  isEmpty(Object[] arr){
        if (arr == null || arr.length == 0) {
            return true;
        }
        return false;
    }

    public static boolean equals(String s1, String s2) {
        if (s1 == null || s2 == null || !s1.equals(s2)){
            return false;
        }
        return true;
    }
}
