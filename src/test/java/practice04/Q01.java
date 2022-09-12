package practice04;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Q01 extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");
        //Click on "click me" button
        Thread.sleep(5000);
        driver.findElement(By.id("growbutton")).click();
        //Verify that "Event Triggered"
        String text=driver.findElement(By.xpath("//p[@id='growbuttonstatus']")).getText();
        System.out.println(text);
        Assert.assertEquals("Event Triggered",text);

    }

}
