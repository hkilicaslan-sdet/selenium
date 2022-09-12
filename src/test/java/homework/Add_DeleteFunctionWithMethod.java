package homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Add_DeleteFunctionWithMethod extends TestBase {

    @Test
    public void test() throws InterruptedException {
// http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
// click on the "Add Element" button 100 times
        WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        int x=40;  // How many buttons wanted to be created
        int y=4;   // How many buttons wanted to be deleted
        for (int i=0;i<x;i++){
            addButton.click();
        }

        List<WebElement> deleteListAfterCreation = driver.findElements(By.xpath("//button[@class='added-manually']"));
        int createdSize=deleteListAfterCreation.size();
        System.out.println("Delete list size after creation : " +createdSize);

// write a function that takes a number, and clicks the "Delete" button
        WebElement deleteButton=driver.findElement(By.xpath("//div[@id='elements']"));
        Thread.sleep(1000);
        for (int i=0;i<y;i++){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            deleteButton.click();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        List<WebElement> deleteListAfterDeleting = driver.findElements(By.xpath("//button[@class='added-manually']"));
        int deletedSize=deleteListAfterDeleting.size();
        System.out.println("Delete list2 size after deletion : " + deletedSize);

// given number of times, and then validates that given number of buttons were deleted
        System.out.println("Integer x = " + x);
        System.out.println("Integer y = " + y);
        System.out.println("Remaining buttons = " +(x-y));

        Assert.assertTrue(deletedSize==(x-y));

    }
}
