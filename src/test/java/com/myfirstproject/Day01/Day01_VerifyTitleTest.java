package com.myfirstproject.Day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_VerifyTitleTest {
    /* Create a new class: VerifyTitleTest 
Navigate to techproeducation homepage 
Verify if google title is “Techpro Education | Online It Courses &amp; Bootcamps”

     */
    public static void main(String[] args) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://techproeducation.com/");
//        get title
            String actualTitle = driver.getTitle();
            String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";

            driver.manage().window().maximize();
//        Verify if actualTitle = expectedTitle
            if(actualTitle.equals(expectedTitle)){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL");
                System.out.println("ACTUAL : "+ actualTitle);
                System.out.println("EXPECTED : "+expectedTitle);
            }

 // driver.getTitle() is to get title of the page
        driver.quit();

        }
}
