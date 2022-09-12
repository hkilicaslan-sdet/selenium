package com.myfirstproject.Day04;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Day04_RadioButton {
    /*  TEST CASE:
Click on Create new account
Enter first name
Enter last name
Enter mobile number or email
Enter new password
Enter birthday(LATER)
Enter gender
Click Sign Up
Create a class : RadioButton
Complete the following task.
Go to https://www.facebook.com/
Click on Create an Account button
Locate the elements of radio buttons
Then click on the radio buttons for your gender if they are not selected    */

    WebDriver driver;
    Faker faker = new Faker();
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void accountSignUp() {
       driver.get("https://www.facebook.com/");
       driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();

    // locating firstname & entering data
        driver.findElement(By.name("firstname")).sendKeys(faker.name().firstName());
    // locating firstname & entering data
        driver.findElement(By.name("lastname")).sendKeys(faker.name().lastName());

        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(faker.phoneNumber().cellPhone());
    // driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("abdvdgd@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys(faker.internet().password());

    // send Jan 20 2000
//        1. locate the month dropdown
        WebElement month = driver.findElement(By.id("month"));
//        2. create select
        Select selectMonth=new Select(month);
//        3. select your option using select object
        selectMonth.selectByVisibleText("Oca");


//        1. locate the day dropdown
        WebElement day = driver.findElement(By.id("day"));
//        2. create select
        Select selectDay=new Select(day);
//        3. select your option using select object
        selectDay.selectByVisibleText("10");

//        1. locate the year dropdown
        WebElement year = driver.findElement(By.id("year"));
//        2. create select
        Select selectYear=new Select(year);
//        3. select your option using select object
        selectYear.selectByVisibleText("2000");

//  locating gender & entering data
        driver.findElement(By.xpath("//input[@value='2']")).click();

// locating "Kaydol" & entering data
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();

    }
}
