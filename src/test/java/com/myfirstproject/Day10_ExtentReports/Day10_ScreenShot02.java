package com.myfirstproject.Day10_ExtentReports;

import com.myfirstproject.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Day10_ScreenShot02 extends TestBase {
    @Test
    public void takeScreenshotOfSpesificElement() throws IOException {
        driver.get("https://www.techproeducation.com");
        WebElement logo= driver.findElement(By.xpath("//div[@data-id='898ce2e']"));
    // 1 - taking screenshot of a spesific element
        File image= logo.getScreenshotAs(OutputType.FILE);
    // 2 - storing the screenshot taken of a spesific element
        String imageName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+imageName+"image.png";
        FileUtils.copyFile(image,new File(path));
    }

    @Test
    public void test2() throws IOException {
        driver.get("https://www.techproeducation.com");
        WebElement logo= driver.findElement(By.xpath("//div[@data-id='898ce2e']"));
        takesScreenshot(logo);
        WebElement socialLogo= driver.findElement(By.xpath("//div[@data-id='d7545f2']"));
        takesScreenshot(socialLogo);
    }

    public void takesScreenshot(WebElement element) throws IOException {
 // 1 - taking screenshot of a spesific element
        File image= element.getScreenshotAs(OutputType.FILE);

 // 2 - storing the screenshot taken of a spesific element
        String imageName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+imageName+"image.png";

        FileUtils.copyFile(image,new File(path));
    }
}
