package practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q04 {


    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

    }
    //@After
    public void trarDown() throws InterruptedException {
        // Wait for 3 seconds
        Thread.sleep(3000);
        // Close the browser
        driver.quit();
    }
    @Test
// ...Exercise4...
        public void test() {
        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        // Click on  Calculator under Micro Apps
        driver.findElement(By.xpath("//*[@id=\"calculatetest\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"function\"]/option[2]")).click();

        // Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("10");
        // Type any number in the second input
        driver.findElement(By.xpath("//*[@id=\"number2\"]")).sendKeys("25");
        // Click on Calculate
        driver.findElement(By.xpath("//*[@id=\"calculate\"]")).click();
        // Get the result
        String answer = driver.findElement(By.id("answer")).getText();
        // Verify the result
        Assert.assertEquals("250",answer);
        // Print the result
        System.out.println("The result is : "+answer);
    }
}
