package com.myfirstproject.Day11;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Day11_JavascriptExecuter extends TestBase {
    @Test
    public void scrollIntoViewTest() throws InterruptedException {
        driver.get("https://www.techproeducation.com");
        Thread.sleep(3000);

        WebElement weOffer= driver.findElement(By.xpath("//*[.='WE OFFER']"));

//  Create jsExecuter object;
        JavascriptExecutor js=(JavascriptExecutor) driver;

//  Execute JS command ; scroll down the target element
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);

//  Scroll over the search input that is at the top of the page
        Thread.sleep(3000);
        WebElement searchBox= driver.findElement(By.xpath(".//input[@type='search']"));
        js.executeScript("arguments[0].scrollIntoView(true);",searchBox);
    }

    @Test
    public void scrollIntoViewTest2() throws InterruptedException {
        driver.get("https://www.techproeducation.com");
        Thread.sleep(3000);

        WebElement weOffer= driver.findElement(By.xpath("//*[.='WE OFFER']"));
        scrollIntoViewJS(weOffer);

        Thread.sleep(3000);
        WebElement searchBox= driver.findElement(By.xpath(".//input[@type='search']"));
        scrollIntoViewJS(searchBox);
    }

    @Test
    public void scrollAllDownThePageTest () throws InterruptedException, IOException {
        driver.get("https://www.techproeducation.com");
        Thread.sleep(3000);
        scrollAllDownByJS();
        takeScreenshot();
        Thread.sleep(3000);
        scrollAllUpByJS();
        takeScreenshot();
    }

    @Test
        public void clickByJSTest (){
        driver.get("https://www.techproeducation.com");
        WebElement LMSLogin= driver.findElement(By.linkText("LMS Login"));
        clickByJS(LMSLogin);
        }

        @Test
        public void setValueByJSTest (){
            driver.get("https://www.techproeducation.com");
            WebElement searchBox= driver.findElement(By.xpath(".//input[@type='search']"));
            setValueByJS(searchBox,"QA");
        }

        @Test
        public void getValueByJSTest (){
        driver.get("https://www.carettahotel.com/");
        WebElement checkIn= driver.findElement(By.id("checkin_date"));
            System.out.println(checkIn.getText());  // Returns empty
            getValueByJS("checkin_date");   // we provide id ofTheElement and it returns the value ofTheElement
        }


        @Test
        public void changeBackgroundColorByJSTest (){
            driver.get("https://www.carettahotel.com/");
            WebElement checkAvailablity= driver.findElement(By.xpath("//input[@type='submit']"));
            changeBackgroundColorByJS(checkAvailablity,"blue");

//            WebElement logInButton= driver.findElement(By.xpath("//a[.='Log in']"));
//            addBorderWithJS(logInButton,"7px yellow");

            WebElement loginButton = driver.findElement(By.xpath("//a[.='Log in']"));
            addBorderWithJS(loginButton,"7px solid yellow");

        }
}
