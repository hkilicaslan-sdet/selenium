package com.myfirstproject.Day06;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class Day06_WindowHandleExample extends TestBase {

    @Test
    public void test01(){
//        Given user is on the https://the-internet.herokuapp.com/windows
            driver.get("https://the-internet.herokuapp.com/windows");
//        Then user verifies the text : “Opening a new window”
           String header1= driver.findElement(By.xpath("//h3[.='Opening a new window']")).getText();
        Assert.assertTrue(header1.equals("Opening a new window"));

//        Then user verifies the title of the page is “The Internet”
        String title1= driver.getTitle();
        Assert.assertEquals(title1,"The Internet");

//      Getting the first window handle
        String firstWindow =driver.getWindowHandle();
        System.out.println("First window handle: "+firstWindow);    // CDwindow-24AC363C8E8E3379A9C2A61E9A7A784A

//        When user clicks on the “Click Here” button
        driver.findElement(By.linkText("Click Here")).click();

//      Getting both windows handle to navigate among them
        Set<String> allWindows=driver.getWindowHandles();
        System.out.println(allWindows); // [CDwindow-F0A3EF1E6EB1FBF115148E0F75CD07CB, CDwindow-73EE4292D3EEA3DB11A9612F11A8129E]

            for (String eachHandle : allWindows){
                if (!eachHandle.equals(firstWindow)){
                    driver.switchTo().window(eachHandle);
                    break;
                }
            }

//        Then user verifies the new window title is “New Window”

        String title2=driver.getTitle();
        Assert.assertTrue(title2.equals("New Window"));
        System.out.println(title2);

//        Then user verifies the text: “New Window”
        String text2= driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(text2.equals("New Window"));

//        When user goes back to the previous window and then verifies the title : “The Internet”
        driver.switchTo().window(firstWindow);
        String title3=driver.getTitle();
            Assert.assertTrue(title3.equals("The Internet"));

    }
}
