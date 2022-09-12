package com.myfirstproject.Day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day03_CheckBox {
    /*  Go to https://the-internet.herokuapp.com/checkboxes
            Locate the elements of checkboxes
            Then click on checkbox1 if box is not selected
            Then click on checkbox2 if box is not selected
            Homework: Then verify that checkbox1 is checked.

     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
// to manage implicitly wait , the syntax we use İs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown() throws InterruptedException {
        driver.quit();
        Thread.sleep(3000);
    }

    @Test
    public void checkTest() throws InterruptedException {
        //  Go to https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //  Locate the elements of checkboxes
      //  WebElement checkBox1 =driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
            // //*[@id="checkboxes"]/input[1] ; to receive by right click copy;xPath !
      //  WebElement checkBox2 =driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

// 2nd way doing by copy paste
        WebElement checkBox1 =driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement checkBox2 =driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

        Thread.sleep(3000);
        //  Then click on checkbox1 if box is not selected
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }


        Thread.sleep(3000);
        //  Then click on checkbox2 if box is not selected
        if (!checkBox2.isSelected()){
            checkBox1.click();
        }

        //  Then verify that checkbox1 is checked.
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox2.isSelected());


    }

    /*  isSelected() is to verify if checkBox or radio button is selected
            if a checkBox is selected isSelected() will return true
            if a checkBox is un-selected isSelected() will return true
     */

}
