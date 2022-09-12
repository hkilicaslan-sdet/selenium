package homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleSearchTest extends TestBase {
    @Test
    public void searchTest(){
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Porcelain teapot"+ Keys.ENTER);
                                    // we can both send the text and search at once

        String result= driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
        System.out.println(result);
    }
}
