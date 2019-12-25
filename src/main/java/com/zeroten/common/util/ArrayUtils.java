package com.zeroten.common.util;

import java.util.Arrays;

public class ArrayUtils {
    public static int[] sort(int[] arr){
        int a = 0;
        int b = 0;
        int[] replay = arr;
        for (int i = 0;i<replay.length;i++){
            for (int j=0;j<replay.length-1;j++){
                a = replay[j];
                b = replay[j+1];
                if (a>b){
                    replay[j] = b;
                    replay[j+1] = a;
                }
            }
        }
        System.out.println(Arrays.toString(replay));
        return replay;
    }
}
