package com.myfirstproject.Day08;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileDownloadTest extends TestBase {
    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");

        driver.findElement(By.linkText("usa.png")).click();
        Thread.sleep(1000); // wait downloading properly
        String homeDirectory=System.getProperty("user.home");
        String path=homeDirectory+"\\Downloads\\usa.png";

        boolean isExist= Files.exists(Paths.get(path));
        Assert.assertTrue(isExist);
    }
}
