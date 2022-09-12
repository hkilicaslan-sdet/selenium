package com.myfirstproject.Day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_URLVerification {
    public static void main(String[] args) {
/*  1.Create a new class: VerifyURLTest
	2.Navigate to TechProEducation homepage
	3.Verify if google homepage url is “https://techproeducation.com/”
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://techproeducation.com/");

        driver.getCurrentUrl();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://techproeducation.com/";

        if(actualURL.equals(expectedURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("ACTUAL URL : "+ actualURL);
            System.out.println("EXPECTED URL : "+expectedURL);
        }

        driver.quit();
    }
}
