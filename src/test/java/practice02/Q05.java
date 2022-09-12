package practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Q05 extends TestBase {
    @Test
    public void test(){

//Signup For Facebook by using Actions class

//Go to Facebook    https://www.facebook.com/
        driver.get("https://www.facebook.com/");
//Click on Create New Account
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        //driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();

        WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);


        actions.click(firstName).
                sendKeys("John").
                sendKeys(Keys.TAB).
                sendKeys("Doe").
                sendKeys(Keys.TAB).
                sendKeys("johndoe2@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("johndoe2@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("john.124534").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("06").
                sendKeys(Keys.TAB).
                sendKeys("Jul").
                sendKeys(Keys.TAB).
                sendKeys("1962").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).
//                sendKeys(Keys.TAB).
//                sendKeys(Keys.TAB).
//                sendKeys(Keys.TAB).
//                sendKeys(Keys.TAB).
//                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();


//fill all the boxes by using keyboard actions


    }
}
