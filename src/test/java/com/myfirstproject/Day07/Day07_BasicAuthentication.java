package com.myfirstproject.Day07;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day07_BasicAuthentication extends TestBase {

    @Test
    public void test(){

//        username : admin
//        password : admin
//        url : the-internet.herokuapp.com/basic_auth
//        the syntax is as:  username:password@URL

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    // verify the login message
        String message=driver.findElement(By.xpath("//p")).getText();
        Assert.assertEquals("Congratulations! You must have the proper credentials.",message);
        Assert.assertTrue(message.contains("Congratulations!"));

        }
}
