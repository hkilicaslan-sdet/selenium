package com.myfirstproject.Day08;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day08_UploadTest extends TestBase {
    @Test
    public void uploadTest(){
        driver.get("https://the-internet.herokuapp.com/upload");


// select an image from the desktop
        String pathFile="C:\\Users\\nm.kljöm\\Downloads\\logo.jpeg";
        WebElement chooseFile= driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys(pathFile);

        driver.findElement(By.id("file-submit")).click();

        String message=driver.findElement(By.xpath("//h3[.='File Uploaded!']")).getText();
        Assert.assertTrue(message.equals("File Uploaded!"));


    }
}
