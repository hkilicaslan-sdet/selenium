package practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02 {
    //  ...Exercise2...
    // Create a new class under Q02
    // Set Path
    // Create chrome driver
    // Maximize the window
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.manage().window().maximize();
    }

    @Test
    public void test01() throws InterruptedException {
        // Open google home page https://www.google.com/
        // Wait for 3 seconds
        driver.get("https://www.google.com/");
        Thread.sleep(3000);
        // Go to the "https://www.amazon.com"
        // Get the title and URL of the page
        driver.navigate().to("https://www.hepsiburada.com/");
        String titleHepsiburada= driver.getTitle();
        System.out.println(titleHepsiburada);
        // Check if the title contains the word "Smile" print console "Title contains Smile" or "Title does not contain Smile"
        // Check if the URL contains the word "auto" print console "URL contains auto" or "URL does not contain auto"
        String hepsURL= driver.getCurrentUrl();
        if (titleHepsiburada.contains("Hepsi")){
            System.out.println("Title contains Hepsi");
        }else {
            System.out.println("Title does not contains Hepsi");
        }
        if (titleHepsiburada.contains("Trend")){
            System.out.println("Title contains Trend");
        }else {
            System.out.println("Title does not contains Trend");
        }
        // Then go to "https://techproeducation.com/"
        driver.get("https://techproeducation.com/");
        // Get the title and check if it contains the word "site" and print "Title contains site" or "Title does not contain site"
        String techproTitle = driver.getTitle();
        if (techproTitle.contains("site")){
            System.out.println("Title contains site");
        }else {
            System.out.println("Title does not contains site");
        }
        // Back to the previous webpage, https://www.amazon.com"
        driver.navigate().back();
        // Refresh the page
        driver.navigate().refresh();
        // Navigate to techproeducation.com
        driver.navigate().forward();

    }
    @After
    public void trarDown() throws InterruptedException {
        // Wait for 3 seconds
        Thread.sleep(3000);
        // Close the browser
        driver.quit();
    }

}
