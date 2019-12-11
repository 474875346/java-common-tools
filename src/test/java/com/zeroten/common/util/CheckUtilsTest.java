package com.zeroten.common.util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckUtilsTest {
    @Test
    public void testisAnyEmpty() {
        Assert.assertEquals(CheckUtils.isAnyEmpty("11","","123123","  123","  "),false);
        Assert.assertEquals(CheckUtils.isAnyEmpty("11","12312","123123","  123","  "),true);
    }
}
