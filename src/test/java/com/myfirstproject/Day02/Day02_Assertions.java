package com.myfirstproject.Day02;

import org.junit.Assert;
import org.junit.Test;

public class Day02_Assertions {
    /*
    Assertion is to check if the expected data is equal to actual data
    Green checkmark  means passed
    Yellow ( x ) means failed
Yasin
        Assertion is done to check if expected data equals to actual data.
    Green checkmark means PASS
    Yellow X means FAIL
    Assert.assertFalse(false); ==> This will PASS
    Assert.assertFalse(true); ==> This will FAIL

    Assert.assertTrue(true); ==> This will PASS
    Assert.assertTrue(false); ==> This will FAIL
     */
    @Test
    public void assertions(){
        Assert.assertEquals(2,2);
        Assert.assertEquals("John","John");
        Assert.assertEquals(true,9==9);
        Assert.assertEquals(3,2+1);

    // to assert true conditions
        Assert.assertTrue(1<3);
        Assert.assertTrue(true);
        Assert.assertTrue("John".contains("o"));

    // to assert false conditions
        Assert.assertFalse(1>3);
        Assert.assertFalse(false);
        Assert.assertFalse("Hasan".contains("z"));

    }
}
