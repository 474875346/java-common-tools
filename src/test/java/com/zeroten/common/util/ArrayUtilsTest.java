package com.zeroten.common.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ArrayUtilsTest {
    @Test
    public void test循环() {
        Integer [] arr = {1,2,3,4,5,6};
        System.out.println("1.for循环使用数组下标");
        for (int index = 0; index < arr.length ; index++){
            System.out.println(arr[index]);
        }
        System.out.println("2.for each 循环");
        for(int numb : arr){
            System.out.println(numb);
        }
        System.out.println("3.Java8新增Lambda表达式");
        Arrays.asList(arr).forEach(integer -> {
            System.out.println(integer);
        });
    }

    @Test
    public void testsort() {
        int[] arr = {7,5,6,4,2,1,3};
        int[] answer = {1,2,3,4,5,6,7};
        Assert.assertEquals(ArrayUtils.sort(arr), answer);

    }
}
