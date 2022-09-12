package com.myfirstproject.Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumClass {
    public static void main(String[] args) {
    // This class should know which driver will be used & where the driver is

        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
    // Create chrome driver
        WebDriver driver=new ChromeDriver();
    // Now we set and created chromedriver, we can use that driver for automation of the test cases
       // driver.get("https://www.google.com/");
      //  driver.get("https://www.amazon.com");
        driver.get("https://www.turkiye.gov.tr");

    }
}
