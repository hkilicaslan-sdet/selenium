package practice03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Q02 extends TestBase {
    @Test
    public void test(){

        //Go to https://testpages.herokuapp.com/styled/drag-drop-javascript.html
        driver.get("https://testpages.herokuapp.com/styled/drag-drop-javascript.html");

        //Drag yellow elements on the red elements below them
        Actions action=new Actions(driver);

        WebElement drag1=driver.findElement(By.id("draggable1"));
        WebElement drag2=driver.findElement(By.id("draggable2"));
        WebElement drop1=driver.findElement(By.id("droppable1"));
        WebElement drop2=driver.findElement(By.id("droppable2"));

        action.dragAndDrop(drag1,drop1).perform();
        action.dragAndDrop(drag2,drop2).perform();

        String drop1Text=drop1.getText();
            System.out.println(drop1Text);
        String drop2Text=drop2.getText();
            System.out.println(drop2Text);
        //Then verify they are dropped.
        Assert.assertEquals("Dropped!",drop1Text);
        Assert.assertEquals("Dropped!",drop2Text);
    }
}
