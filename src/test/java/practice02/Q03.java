package practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Q03 extends TestBase {

    @Test
    public void test(){
// go to amazon homepage
        driver.get("https://www.amazon.com/");
        WebElement hooverArea=driver.findElement(By.id("nav-link-accountList"));

// hover mouse over the hello, signIn element at the top right
        WebElement hello= driver.findElement(By.id("nav-link-accountList"));
        Actions actions=new Actions(driver);
        actions.moveToElement(hello).perform();

        // Click on the Create list link in the menu that opens
        driver.findElement(By.linkText("Create a List")).click();

        // and verify that title is equal to "Your List"
        String title=driver.getTitle();
        Assert.assertEquals("Your List",title);




    }
}
