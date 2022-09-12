package com.myfirstproject.Day12;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day12_NullPointerException {

    Faker faker; // must be as ; Faker faker =new Faker();
    @Test
    public void nullPointerTest1(){
        System.out.println(faker.name().fullName());
    }

    WebDriver driver;   // must be as ;WebDriver driver =new ChromeDriver();
    @Test
    public void nullPointerTest2(){
        driver.get("https://www.google.com");
    }
}
