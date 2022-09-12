package com.myfirstproject.Day04;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Day04_Dropdown {
    /*  //Go to https://the-internet.herokuapp.com/dropdown
//1.Create method selectByIndexTest and Select Option 1 using index
//2.Create method selectByValueTest Select Option 2 by value
//3.Create method selectByVisibleTextTest Select Option 1 value by visible text
//4.Create method printAllTest Print all dropdown value
//5. Verify the dropdown has Option 2 text
//6.Create method printFirstSelectedOptionTest Print first selected option
//7.Find the size of the dropdown, Print "Expected Is Not Equal Actual"
    if there are not 3 elements in the dropdown.

     */
    WebDriver driver;

    @Before
    public void setUp() {
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
    public void selectByIndexTest() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    // locate the dropdown
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
    // Create select class
        Select select = new Select(dropdownElement);
    // Select any option from dropdown by using select selectByIndex
        select.selectByIndex(1);    // default one is 0
    }

    @Test
    public void selectByValueTest() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    // locate the dropdown
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
    // Create select class
        Select select = new Select(dropdownElement);
    // Select any option from dropdown by using select selectByValue
        select.selectByValue("1");
    }
    @Test
    public void selectByVisibleText() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    // locate the dropdown
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
    // Create select class
        Select select = new Select(dropdownElement);
    // Select any option from dropdown by using select selectByVisibleText
        select.selectByVisibleText("Option 2");
    }

//4.Create method printAllTest Print all dropdown value
    @Test
    public void printAllTest(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
    // locate the dropdown
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
    // Create select class
        Select select = new Select(dropdownElement);
    // Getall-dropdown elements and print them
        List<WebElement> allOptions=select.getOptions();
        for (WebElement w:allOptions  ) {
            System.out.println(w.getText());
        }
//5. Verify the dropdown has Option 2 text
        boolean flag=false;
        for (WebElement k:allOptions ) {
            if (k.getText().equals("Option 2")){
                flag=true;
                System.out.println(k.getText()+ "  contains Option 2");
            }
        }
        Assert.assertTrue(flag);    // will pass if flag is true. Will be true only if there is a match

//6.Create method printFirstSelectedOptionTest Print first selected option
        WebElement firstSelected = select.getFirstSelectedOption();
        System.out.println("DEFAULT SELECTED : "+firstSelected.getText());

//7.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
        int dropdownSize= allOptions.size();
        System.out.println(dropdownSize);
        Assert.assertEquals("Expected Is Not Equal Actual",3,dropdownSize);

    }
}
