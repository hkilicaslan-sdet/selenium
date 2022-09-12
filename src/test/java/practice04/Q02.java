package practice04;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Q02 extends TestBase {
    @Test
    public void test(){
        //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");
        //Click all the buttons and verify they are all clicked
        driver.findElement(By.id("onblur")).click();
// the first click is for the previous element
        driver.findElement(By.id("onclick")).click();
        driver.findElement(By.id("onclick")).click();

        Actions actions=new Actions(driver);

        WebElement contextMenu= driver.findElement(By.id("oncontextmenu"));
        WebElement doubleClick=driver.findElement(By.id("ondoubleclick"));
        WebElement onFocus=driver.findElement(By.id("onfocus"));
        WebElement onKeyDown=driver.findElement(By.id("onkeydown"));
        WebElement onKeyUp=driver.findElement(By.id("onkeyup"));
        WebElement onKeyPress=driver.findElement(By.id("onkeypress"));
        WebElement onMauseOver=driver.findElement(By.id("onmouseover"));
        WebElement onMauseLeave=driver.findElement(By.id("onmouseleave"));
        WebElement onMauseDown=driver.findElement(By.id("onmousedown"));

        actions.contextClick(contextMenu).
                doubleClick(doubleClick).
                click(onFocus).
                click(onKeyDown).sendKeys(Keys.ENTER).
                click(onKeyUp).sendKeys(Keys.SPACE).
                click(onKeyPress).sendKeys(Keys.SPACE).
                moveToElement(onMauseOver).
                moveToElement(onMauseLeave).
                moveToElement(onMauseOver).
                click(onMauseDown).                build().perform();

        List<WebElement> clickedButtons = driver.findElements(By.xpath("//p[.='Event Triggered']"));

        Assert.assertEquals(11, clickedButtons.size());
    }
}
