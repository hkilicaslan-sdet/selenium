package com.myfirstproject.Day10_ExtentReports;

import com.myfirstproject.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Day10_ScreenShot01 extends TestBase {
    @Test
    public void takeScreenShotTest() throws IOException {
//        System.out.println(System.getProperty("user.dir"));
//        driver.get("https://www.techproeducation.com");
//        driver.get("https://www.linkedin.com");
          driver.get("https://www.amazon.com");
          driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Porcelain Teapot"+ Keys.ENTER);

        takeScreenshot();

    }

    public void takeScreenshot() throws IOException {

// Taking screenshot WE ALSO PUT ONE COPY TO TestBase !!!

       File image=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //or seperate syntax      TakesScreenshot ts= (TakesScreenshot) driver;
                        //        File image2=ts.getScreenshotAs(OutputType.FILE);

// Saving screenshot
    // we can add a time sekans to change the image names to get new & keep every one
        String imageName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // we need to define the path ;
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+imageName+"image.png";
        FileUtils.copyFile(image,new File(path));


    }
}
