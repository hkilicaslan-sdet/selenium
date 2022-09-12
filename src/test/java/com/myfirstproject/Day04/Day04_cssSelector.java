package com.myfirstproject.Day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_cssSelector {

    WebDriver driver;

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
    public void cssTest(){
        driver.get("http://a.testaddressbook.com/sign_in");
//        Find the username using css selector
        // cssSelector syntax ==> tg[attribute='value']
        driver.findElement(By.cssSelector("input[id='session_email']")).sendKeys("testtechproed@gmail.com");
                    // even ==> .form-control OR input.form-control works

//        Find the password using css selector
        driver.findElement(By.cssSelector("input#session_password")).sendKeys("Test1234!");
                     // even ==> #session_password works

//        Find log in button using css selector
        driver.findElement(By.cssSelector("input[name='commit']")).click();

    }
}
