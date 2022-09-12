package homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Synchronization2 extends TestBase {
//
//    Create a class:Synchronization2.
//    Create a method: synchronization2
    @Test
    public void synchronization2(){
//    Go to https://the-internet.herokuapp.com/dynamic_loading/2
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

//    When user clicks on the Start button
        driver.findElement(By.xpath("//div[@id='start']/button")).click();

//    Then verify the ‘Hello World!’ Shows up on the screen
        String message=driver.findElement(By.id("finish")).getText();
        Assert.assertEquals("Hello World!",message);
    }
}
