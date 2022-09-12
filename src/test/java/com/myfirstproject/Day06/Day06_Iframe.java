package com.myfirstproject.Day06;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Day06_Iframe extends TestBase {

//        Create a class: IFrameTest
//        Create a method: iframeTest
    @Test
    public void iframeTest(){
//        Go to https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");
//        Verify the Bolded text contains “Editor”
        String header=driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        Assert.assertTrue(header.contains("Editor"));

//        Locate the text box: for that we need to switchTo()  iframe
  // There are 3 ways to switch to iframe name or id / index / WebElement
    //    driver.switchTo().frame(0); // with index
          driver.switchTo().frame("mce_0_ifr"); // with id
    //    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"))); // with WebElement

//        Delete the text in the text box
        WebElement box=driver.findElement(By.xpath("//p"));
        box.clear();
//        Type “This text box is inside the iframe”
        box.sendKeys("This text box is inside the iframe");

//        Verify the text Elemental Selenium text is displayed on the page
        driver.switchTo().parentFrame();
    // or ==>    driver.switchTo().defaultContent();

    //    String element= driver.findElement(By.partialLinkText("Elemental S")).getText(); or
        String element= driver.findElement(By.linkText("Elemental Selenium")).getText();
        System.out.println(element);

        Assert.assertEquals(element,"Elemental Selenium");

    }

    @Test
    public void test2(){
//Go to https://testpages.herokuapp.com/
        driver.get("https://testpages.herokuapp.com/");
//Click on "iFrames Test Page" under frames
        driver.findElement(By.id("iframestest")).click();
//Assert that it has an iframe with header "Nested Page Example"

        driver.switchTo().frame(1);
        WebElement header=driver.findElement(By.xpath("//h1[.='Nested Page Example']"));
        Assert.assertTrue(header.isDisplayed());

        driver.switchTo().defaultContent();
        driver.navigate().back();
       List<WebElement> iframeList= driver.findElements(By.xpath("//iframe"));
        System.out.println("Num of iframes : " +iframeList.size());

    }
}



