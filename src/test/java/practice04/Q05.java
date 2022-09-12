package practice04;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Q05 extends TestBase {
    @Test
    public void test(){
//Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        //Fill the username, password and textArea comment:
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Tom");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abc123");
        WebElement textArea=driver.findElement(By.xpath("//textarea[@name='comments']"));
        textArea.clear();
        textArea.sendKeys("Shall we succeed it?");

        //Choose a file and upload it
        String filePath= "C:\\Users\\nm.kljöm\\Downloads/textfile.txt";
        driver.findElement(By.xpath("//input[@name='filename']")).sendKeys(filePath);

        //Select checkbox,
        WebElement checkBox1= driver.findElement(By.xpath("(//input[@name='checkboxes[]'])[1]"));
        WebElement checkBox2= driver.findElement(By.xpath("(//input[@name='checkboxes[]'])[2]"));
        WebElement checkBox3= driver.findElement(By.xpath("(//input[@name='checkboxes[]'])[3]"));
        if ((!checkBox1.isSelected())){
            checkBox1.click();
        }if ((checkBox2.isSelected())){
            checkBox2.click();
        }if ((checkBox3.isSelected())){
            checkBox3.click();
        }
    //    radio item and
        driver.findElement(By.xpath("//input[@value='rd3']")).click();
        driver.findElement(By.xpath("//option[@value='ms4']")).click();
    //    and dropdowns
        WebElement dropDown=driver.findElement(By.xpath("//select[@name='dropdown']"));
        Select select=new Select(dropDown);
        select.selectByValue("dd2");

        //Click on submit
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //Verify that uploaded file name is on the Form Details.
        WebElement uploadedFile=driver.findElement(By.id("_valuefilename"));
        Assert.assertEquals("textfile.txt",uploadedFile.getText());

    }
}
