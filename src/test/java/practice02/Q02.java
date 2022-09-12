package practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Q02 extends TestBase {
    @Test
    public void test(){
// 1. Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

        // 2. Click "CLICK ME" of JavaScript Alert
        driver.findElement(By.xpath("//span[@id='button1']")).click();

        // 3. Get the pop-up text
        String allert=driver.switchTo().alert().getText();
        System.out.println(allert);

        // 4. Verify that message is "I am an alert box!"
        Assert.assertTrue(allert.equals("I am an alert box!"));

        // 5. Accept pop-up

        driver.switchTo().alert().accept();

// or ; bcs without accepting allert we cannot reach current url. reaching/getting url also
        // some other way to assert accepting allert
        String url= driver.getCurrentUrl();
        Assert.assertEquals("http://webdriveruniversity.com/Popup-Alerts/index.html",url);
        driver.quit();
    }
}
