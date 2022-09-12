package com.myfirstproject.Day07;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Day07_Actions2 extends TestBase {
    @Test
    public void hoverOverTest(){
//        Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        WebElement hooverArea=driver.findElement(By.id("nav-link-accountList"));
//        When use click on “Account” link
        Actions actions=new Actions(driver);
        actions.moveToElement(hooverArea).perform();
        driver.findElement(By.linkText("Account")).click();

//        Then verify the page title contains “Your Account”
        String title=driver.getTitle();
        Assert.assertTrue(title.contains("Your Account"));

    }
}
