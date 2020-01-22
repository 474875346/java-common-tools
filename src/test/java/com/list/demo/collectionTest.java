package com.list.demo;


import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Random;

public class collectionTest {
    public static void main(String[] args) {
        System.out.println("冒泡排序:");
        collection.BubbleSort();
        System.out.println("插入排序:");
        collection.InsertionSort();
        System.out.println("选择排序:");
        collection.SelectionSort();
    }

    @Test
    public void test() {
        // n 次幂
        int multiple = 0;
        // 长度
        int length;
        // 不成立的次数
        int fail = 0;
        while (true) {
            length = (int) Math.pow(2, ++multiple);
            if (length >= Integer.MAX_VALUE) {
                break;
            }
            // 随机生成一个正整数
            int num = new Random().nextInt(Integer.MAX_VALUE - 1);
            // 判断等式是否成立
            if ((num & (length - 1)) != num % length) {
                fail++;
            } else {
                System.out.printf("2的%d次幂，length=2^%d=%d,转换成二进制：length=%s，,length-1=%s\n"
                        , multiple, multiple, length, Integer.toBinaryString(length), Integer.toBinaryString(length - 1));
            }
        }
        if (fail == 0) {
            System.out.printf("当 length 为 2 的次幂时，num & (length - 1) = num %s length 等式成立, 最大%d次幂\n",
                    "%", multiple - 1);
        }
    }
}
