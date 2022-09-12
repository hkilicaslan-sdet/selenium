package homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class VerifyText_SedNonUrna extends TestBase {
    @Test
    public void verifyText() {
        driver.get("https://jqueryui.com/accordion/");
        driver.switchTo().frame(0);
// click on section 2
        driver.findElement(By.id("ui-id-3")).click();
        String text= driver.findElement(By.xpath("//div[@id='ui-id-4']/p")).getText();
        System.out.println(text);
// verify "Sed non urna."
        Assert.assertTrue(text.contains("Sed non urna."));
    }
}