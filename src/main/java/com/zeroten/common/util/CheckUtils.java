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
}
