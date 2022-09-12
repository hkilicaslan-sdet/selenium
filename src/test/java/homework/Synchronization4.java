package homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Synchronization4 extends TestBase {

//    Create a class:Synchronization4. Create a method: isEnabled
        @Test
    public void isEnabled(){
//    Go to https://the-internet.herokuapp.com/dynamic_controls
            driver.get("https://the-internet.herokuapp.com/dynamic_controls");

//    Click enable Button

            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
            WebElement button= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='swapInput()']")));

            Assert.assertTrue(button.isEnabled());
//    And verify the message is equal to “It's enabled!”
      String text1= driver.findElement(By.xpath("//p[@id='message']")).getText();
            System.out.println("text1 : "+ text1);
            Assert.assertEquals("It's enabled!",text1);

//    And verify the textbox is enabled (I can type in the box)
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("I can type in the box");

//    And click on Disable button
            driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();

//    And verify the message is equal to “It's disabled!”
            String text2= driver.findElement(By.xpath("//p[@id='message']")).getText();
            System.out.println("text2 : "+ text2);
            Assert.assertEquals("It's disabled!",text2);

//    And verify the textbox is disabled (I cannot type in the box)
           WebElement textBoxDisabled=driver.findElement(By.xpath("//input[@type='text']"));
            System.out.println(textBoxDisabled.getText());
      //    NOTE: .isEnabled(); is used to check if an element is enabled or not
        }
}
