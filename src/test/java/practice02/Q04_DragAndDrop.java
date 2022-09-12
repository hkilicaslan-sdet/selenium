package practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Q04_DragAndDrop extends TestBase {
    @Test
    public void  test(){
// Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        // Match the capitals by country.
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        Actions actions=new Actions(driver);
        WebElement oslo= driver.findElement(By.xpath("//div[@id='box1']"));
        WebElement stockholm= driver.findElement(By.xpath("//div[@id='box2']"));
        WebElement washington= driver.findElement(By.xpath("//div[@id='box3']"));
        WebElement copenhagen= driver.findElement(By.xpath("//div[@id='box4']"));
        WebElement seoul= driver.findElement(By.xpath("//div[@id='box5']"));
        WebElement rome= driver.findElement(By.xpath("//div[@id='box6']"));
        WebElement madrid= driver.findElement(By.xpath("//div[@id='box7']"));


        WebElement norway= driver.findElement(By.xpath("//div[@id='box101']"));
        WebElement sweden= driver.findElement(By.xpath("//div[@id='box102']"));
        WebElement usa= driver.findElement(By.xpath("//div[@id='box103']"));
        WebElement denmark= driver.findElement(By.xpath("//div[@id='box104']"));
        WebElement southKorea= driver.findElement(By.xpath("//div[@id='box105']"));
        WebElement italy= driver.findElement(By.xpath("//div[@id='box106']"));
        WebElement spain= driver.findElement(By.xpath("//div[@id='box107']"));

        actions.dragAndDrop(oslo,norway).
                dragAndDrop(stockholm,sweden).
                dragAndDrop(washington,usa).
                dragAndDrop(copenhagen,denmark).
                dragAndDrop(madrid,spain).
                dragAndDrop(seoul,southKorea).
                dragAndDrop(rome,italy).
                perform();


    }
}
