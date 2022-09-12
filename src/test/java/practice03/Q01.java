package practice03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Q01 extends TestBase {

    @Test
            public void test(){
//   Go to http://the-internet.herokuapp.com/add_remove_elements/
    driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    // click on the "Add Element" button 100 times
        createButton(46);
        deleteButton(10);

//    click on the "Add Element" button 100 times
//    write a method that takes a number, and clicks the "Delete" button given number of times,
//    and then validates that given number of buttons were deleted

    }

    public void createButton (int numberAdd){
        WebElement addButton = driver.findElement(By.xpath("//div[@id='content']/div/button"));
    // 2nd way     WebElement addButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        int x=40;  // How many buttons wanted to be created
        int y=4;   // How many buttons wanted to be deleted
        for (int i=0;i<numberAdd;i++){
            addButton.click();
        }
    }
    public void deleteButton (int numberDel){
        WebElement deleteButton=driver.findElement(By.xpath("//div[@id='elements']"));
        for (int i=0;i<numberDel;i++){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            deleteButton.click();
        }
    }
}
