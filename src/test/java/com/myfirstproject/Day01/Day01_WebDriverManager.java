package com.myfirstproject.Day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_WebDriverManager {
    public static void main(String[] args) {

        // setup chrome driver
 // Instead this ==>  System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();

    // THE REST IS SAME
        // create web driver object
        WebDriver driver=new ChromeDriver();

        //Maximize the window ; test should be done fullscreen
        driver.manage().window().maximize();    // to maximize / fullscreen window

        // start your test case
        driver.get("https://www.youtube.com/");
// wait a few seconds before going forward



    }
}
