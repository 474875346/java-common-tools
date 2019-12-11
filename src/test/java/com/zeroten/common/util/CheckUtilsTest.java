package com.zeroten.common.util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckUtilsTest {

    @Test
    public void testisAnyEmpty() {
        Assert.assertEquals(CheckUtils.isAnyEmpty("11","","123123","  123","  "),false);
        Assert.assertEquals(CheckUtils.isAnyEmpty("11","12312","123123","  123","  "),true);
    }

    @Test
    public void testisEmpty() {
        Assert.assertEquals(CheckUtils.isEmpty(null),true);
        String[] arr = {};
        Assert.assertEquals(CheckUtils.isEmpty(arr),true);
        String[] arr1 = {"1","2"};
        Assert.assertEquals(CheckUtils.isEmpty(arr1),true);
    }
}
