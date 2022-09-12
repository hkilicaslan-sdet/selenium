package com.myfirstproject.Day08;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Day08_ScrollingUpDown extends TestBase {
    @Test
    public void pageUp_DownTest() throws InterruptedException {
//        Create a class: ActionClass3
//        Create test method : scrollUpDown()
//        Go to techproeducation
        driver.get("https://www.techproeducation.com");
        Actions actions=new Actions(driver);

//        Scroll the page down
    //page down ==> scrollDown
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();

    // using build() is prefered if we need to type chain actions
        // perform() must be used after build()

        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).build().perform();

Thread.sleep(2000);
    //arrow down ==> scrollDown
        actions.sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                perform();

//        Scroll the page up
        actions.sendKeys(Keys.ARROW_UP).
                sendKeys(Keys.PAGE_UP).
                sendKeys(Keys.ARROW_UP).
                perform();
    }
}
