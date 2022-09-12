package com.myfirstproject.Day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Day02_LocatersIntro {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
// to manage implicitly wait , the syntax we use İs
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void login(){
//    user goes to http://a.testaddressbook.com/sign_in
//    Locate the elements of email textbox, password textbox, and signin button
//    Enter below username and password then click sign in button
//    Username : testtechproed@gmail.com
//    Password : Test1234!
//    Then verify that the expected user id testtechproed@gmail.com (USE getText() method to
//            get the text from the page)
//    Verify the Addresses and Sign Out texts are displayed
//    Find the number of total link on the page
//      Print all links names
//    Sign out from the page


//    user goes to http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");

//    Locate the elements of email textbox, password textbox, and signin button
        WebElement emailBox =driver.findElement(By.id("session_email"));
            emailBox.sendKeys("testtechproed@gmail.com");
        WebElement passwordBox = driver.findElement(By.id("session_password"));
            passwordBox.sendKeys("Test1234!");
        WebElement signInButton=driver.findElement(By.name("commit"));
            signInButton.click();

//    Then verify that the expected user id testtechproed@gmail.com (USE getText() method to
//            get the text from the page)
        String actualEmail= driver.findElement(By.className("navbar-text")).getText();
        String expectedEmail = "testtechproed@gmail.com";
        Assert.assertEquals(actualEmail,expectedEmail);

//    Verify the Addresses and Sign Out texts are displayed
        WebElement adressElement= driver.findElement(By.linkText("Addresses"));
        Assert.assertTrue(adressElement.isDisplayed());

        WebElement signOutElement=driver.findElement(By.linkText("Sign out"));
        Assert.assertTrue(signOutElement.isDisplayed());

//    Find the number of total link on the page
        List<WebElement> listOfLinks=driver.findElements(By.tagName("a"));
        System.out.println("Number of Links : " + listOfLinks.size());

//      Print all links names
        for (WebElement w: listOfLinks  ) {
            System.out.println(w.getText());
        }

//     Sign out from the page
        driver.findElement(By.xpath("//a[@data-test='sign-out']")).click();

// need to be asserted if signed-out properly !!!
   // we can locate a core element on sign-in page and assert it
   // e.g sign-in url, any webelement on sign-in page.

        String actualURL= driver.getCurrentUrl();
        Assert.assertTrue(actualURL.equals("http://a.testaddressbook.com/sign_in"));


// getText() is used to get a webElement & returns String
// isDisplayed () ; is to check if a WebElement is displayed on the page. Returns boolean

    }
}
