package com.myfirstproject.Day12;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day12_Syncronisation extends TestBase {
    @Test
    public void explicitWait(){
//        Create a class:Synchronization
//        Create a method: explicitWait
//        Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        When user clicks on the Start button
        driver.findElement(By.xpath("//div[@id='start']/button")).click();
//        Then verify the ‘Hello World!’ Shows up on the screen
        // throws NoSuchElementException and to handle this we need to use ExplicitWaiting

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    //wait is doig two things; waiting for the text appear; 2. return the result as WebElement
        WebElement helloWorld= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']/h4")));
        String helloWorldText= helloWorld.getText();
        Assert.assertEquals("Hello World!",helloWorldText);

//        WebElement helloWorld= driver.findElement(By.xpath("//*[@id='finish']/h4"));
//        String text= helloWorld.getText();
/*
        NOTE: This code fails because the Hello World text is hidden for about 5 seconds
        We should wait for the element using explicit wait to be displayed
        WebElement helloWorld = driver.findElement(By.xpath("//div[@id='finish']//h4"));
        String helloWorldText = helloWorld.getText();
        Assert.assertEquals("Hello World!",helloWorldText);
 */
    }

    @Test
    public void explicitWait1() throws InterruptedException {
//        Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
//        When user clicks on the Start button
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
//        Then verify the 'Hello World!' Shows up on the screen

//        1. create WebDriverWait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait does 2 things: 1. waits for the locator until the text of the locator matches
//        2. returns true if text matches in 10 seconds, returns false if text does not match in 10 seconds
        boolean isTrue = wait.until(ExpectedConditions.
                        textToBe(By.xpath("//div[@id='finish']//h4"),"Hello World!"));
        Assert.assertTrue(isTrue);
    }
}
