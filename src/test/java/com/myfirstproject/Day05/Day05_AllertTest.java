package com.myfirstproject.Day05;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day05_AllertTest extends TestBase {
    //    Create a class: AlertTest
//    Create setUp method
    @Test
    public void acceptAllert() throws InterruptedException {
//    Go to https://the-internet.herokuapp.com/javascript_alerts
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//        acceptAlert() => click on the first alert,
//        get the text of the allert
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        String allertText = driver.switchTo().alert().getText();
//        verify the text “I am a JS Alert” ,
        System.out.println(allertText);
        Assert.assertEquals("I am a JS Alert", allertText);
//            click OK and Verify “You successfully clicked an alert”
        Thread.sleep(3000);
        driver.switchTo().alert().accept();     // clicks OK and

        String oKMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals("You successfully clicked an alert", oKMessage);
    }

    @Test
    public void dismissAllert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//        dismissAlert()=>
//        click on the second alert,
        driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
        String allertText2=driver.switchTo().alert().getText();
        System.out.println(allertText2);
//        verify text "I am a JS Confirm”,
        Assert.assertEquals(allertText2,"I am a JS Confirm");
//        click cancel, and
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();

//        Verify “You clicked: Cancel”
        String cancelResult=driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals("You clicked: Cancel",cancelResult);

    }
    @Test
    public void sendKeysAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//        sendKeysAlert()=> click on the third alert,
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

//    verify text “I am a JS prompt”,
        String allertText3=driver.switchTo().alert().getText();
        System.out.println(allertText3);
        Assert.assertEquals("I am a JS prompt",allertText3);

//    type “Hello World”,
        driver.switchTo().alert().sendKeys("Hello World");
//    click OK,
        driver.switchTo().alert().accept();
//    and Verify “You entered: Hello World”
        String result=driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals("You entered: Hello World",result);

    }
}
