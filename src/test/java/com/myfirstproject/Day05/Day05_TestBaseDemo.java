package com.myfirstproject.Day05;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;

public class Day05_TestBaseDemo extends TestBase {
    @Test
    public void test1(){
        driver.get("https://us06web.zoom.us/postattendee?mn=eysuASrxX-UL8-KhmKG8DsUvHzeGB6x_kffx.HiPLw9m2l-Zv8dyQ");
        System.out.println(driver.getTitle());

    }

    @Test
    public void test2(){
        driver.get("https://github.com/");
        System.out.println(driver.getTitle());

    }
}
