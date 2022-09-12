package com.myfirstproject.Day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day02_LocatersIntro_Yasin {
    //    user goes to http://a.testaddressbook.com/sign_in
//    Locate the elements of email textbox, password textbox, and signin button
//    Enter below username and password then click sign in button
//    Username : testtechproed@gmail.com
//    Password : Test1234!
//    Then verify that the expected user id testtechproed@gmail.com (USE getText() method to get the text from the page)
//    Verify the Addresses and Sign Out texts are displayed
//    Find the number of total link on the page
//    Print all link names
//    Sign out from the page

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void login(){

//      user goes to http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");

//      Locate the elements of email textbox, password textbox, and signin button
        WebElement emailBox =driver.findElement(By.id("session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");

        WebElement passwordBox = driver.findElement(By.id("session_password"));
        passwordBox.sendKeys("Test1234!");

        WebElement signInButton = driver.findElement(By.name("commit"));
        signInButton.click();

//      Then verify that the expected user id testtechproed@gmail.com (USE getText() method to get the text from the page)
        String actualEmail = driver.findElement(By.className("navbar-text")).getText();
        String expectedEmail = "testtechproed@gmail.com";
        Assert.assertEquals(expectedEmail,actualEmail);

//      Verify the Addresses and Sign Out texts are displayed
        WebElement addressElement = driver.findElement(By.linkText("Addresses"));
        Assert.assertTrue(addressElement.isDisplayed());

        WebElement signOutElement = driver.findElement(By.linkText("Sign out"));
        Assert.assertTrue(signOutElement.isDisplayed());

//      Find the number of total link on the page
//      a tag is used to create link
        List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
        System.out.println("listOfLinksSize = " + listOfLinks.size());

//      Print all link names
        for(WebElement w : listOfLinks){
            System.out.println(w.getText());
        }

//     Sign out from the page
        driver.findElement(By.xpath("//a[@data-test='sign-out']")).click();

//     We are able to click on signout button
//     We need to assert the sign out functionality works
//     We can locate a core element for assertion
//     Or we can use URL for assertion
//     Sign out URL :http://a.testaddressbook.com/
//     Assert that after clicking signout, the URL shoud be http://a.testaddressbook.com/sign_in

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.equals("http://a.testaddressbook.com/sign_in"));

        /*
        getText() is used to get the text of a webelement. It returns a String.
        isDisplayed() is used to check if an element is on the page or not. It returns a boolean value.
         */
    }
}
