package practice04;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Path;

public class Q03 extends TestBase {
    @Test
    public void test(){
//Go to https://testpages.herokuapp.com/
        driver.get("https://testpages.herokuapp.com/");
        //Click on File Downloads
        driver.findElement(By.id("download")).click();

        //Click on Server Download
        driver.findElement(By.id("server-download")).click();

        //Verify that file is downloaded    ; C:\Users\nm.kljöm\Downloads
        String path=System.getProperty("user.home")+"/Downloads/textfile.txt";
        System.out.println(path);
        boolean  isDownloaded=(Files.exists(Path.of(path)));
        Assert.assertTrue(isDownloaded);





    }
}
