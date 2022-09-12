package homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class IframeTest extends TestBase {

// Create a class: IframeTest
// Method : iframeTest
    @Test
    public void iframeTest() throws InterruptedException {
// When a user goes to https://html.com/tags/iframe/
        driver.get("https://html.com/tags/iframe/");
// Then click on the first video play to play the video
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
// BONUS
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
// Then wait for a 12 second (hard wait)
        Thread.sleep(12000);
// Then stop the play
        driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']")).click();
//Note:
// The page is too slow. Do some manual testing and understand the behavior
    }
}
