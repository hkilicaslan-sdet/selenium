package com.myfirstproject.Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_BasicNavigations {
    /*
    Steps:
//        Create a new class under : BasicNavigations
  //      Create main method
    //    Set Path
      //  Create chrome driver
        //Maximize the window
//        Open google home page https://www.walmart.com/.
  //      On the same class, Navigate to amazon home page https://www.amazon.com/
    //    Navigate back to google
      //  Navigate forward to amazon
        //Refresh the page
        //Close/Quit the browser
     */
    public static void main(String[] args) throws InterruptedException {
 // set driver and path
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
 // create web driver object
        WebDriver driver=new ChromeDriver();
 //Maximize the window ; test should be done fullscreen
        driver.manage().window().maximize();    // to maximize / fullscreen window
 // start your test case
        driver.get("https://www.youtube.com/");
// wait a few seconds before going forward
        Thread.sleep(3000);

 // On the same class, Navigate to amazon home page https://www.amazon.com/
        driver.navigate().to("https://techproeducation.com/tr/");
        Thread.sleep(3000);

 // Navigate back to google
        driver.navigate().back();
        Thread.sleep(3000);

 // Navigate forward to amazon
        driver.navigate().forward();
        Thread.sleep(3000);

//Refresh the page
        driver.navigate().refresh();

//Close/Quit the browser : we have two options to close the window
        driver.close();
        driver.quit();

    }
/*  INTERVIEW QUESTIONS

    1)What is the difference between get & navigate?
Smilarities;
        both open a new page URL
Differencies
        get() do not require ".to()"
        get() cannot be used to move back / forward.
            we use navigate().to() for moving back , forward & refresh
        get() accepts only String ;
            navigate().to() accepts either String or URL.url as parameter

   2) What is the difference between close & quit?
        1. close() closes only the ACTIVE WORKING window
        2. quit() closes ALL WORKING windows
 */

}


