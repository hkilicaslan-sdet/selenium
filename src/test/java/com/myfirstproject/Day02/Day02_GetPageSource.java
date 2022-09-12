package com.myfirstproject.Day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSource {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        String pageSource = driver.getPageSource();
        //pageSource.contains("Registry");
        if (pageSource.contains("Registry")){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed - Do not contain Registry ");
        }
        driver.quit();
    }
}
