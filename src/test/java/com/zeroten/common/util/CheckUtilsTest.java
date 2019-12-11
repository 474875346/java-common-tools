package com.zeroten.common.util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckUtilsTest {

    @Test
    public void testisAnyEmpty() {
        Assert.assertEquals(CheckUtils.isAnyEmpty("11", "", "123123", "  123", "  "), false);
        Assert.assertEquals(CheckUtils.isAnyEmpty("11", "12312", "123123", "  123", "  "), true);
    }

    @Test
    public void testisEmpty() {
        Assert.assertEquals(CheckUtils.isEmpty(null), true);
        String[] arr = {};
        Assert.assertEquals(CheckUtils.isEmpty(arr), true);
        String[] arr1 = {"1", "2"};
        Assert.assertEquals(CheckUtils.isEmpty(arr1), true);
    }

    @Test
    public void testequals() {
        Assert.assertEquals(CheckUtils.equals("1","2"),false);
        Assert.assertEquals(CheckUtils.equals("2","2"),true);
        Assert.assertEquals(CheckUtils.equals(null,"2"),false);
        Assert.assertEquals(CheckUtils.equals("1",null),false);
    }

    @Test
    public void testIntegerequals() {
        Assert.assertEquals(CheckUtils.equals(1,1),true);
        Assert.assertEquals(CheckUtils.equals(1,2),false);
        Assert.assertEquals(CheckUtils.equals(null,2),false);
        Assert.assertEquals(CheckUtils.equals(1,null),false);
    }

}
