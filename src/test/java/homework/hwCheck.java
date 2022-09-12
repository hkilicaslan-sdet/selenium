package homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class hwCheck extends TestBase {

        @Test
        public void datePickerTest() throws InterruptedException {
            // Go to Url
            driver.get("http://jqueryui.com/datepicker/");

            // Switch to iframe
            driver.switchTo().frame(0);

            // Locate datepicker Webelement and click on it
            driver.findElement(By.id("datepicker")).click();
            Thread.sleep(3000);

            // Locate current date from table and click the next day
            driver.findElement(By.xpath("//*[contains(@class,'ui-datepicker-today')]//following::td[1]")).click();

        }
}