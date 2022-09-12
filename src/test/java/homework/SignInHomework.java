package homework;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

//  1. Create a class SignInHomework
        public class SignInHomework {

        WebDriver driver;
        Faker faker = new Faker();
        @Before
        public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
        @After
        public void tearDown() throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }
            @Test
            public void accountSignUp() throws InterruptedException {
//      2. Go to http://automationpractice.com/index.php
            driver.get("http://automationpractice.com/index.php");
//      3. Click on sign in link
            driver.findElement(By.xpath("//a[@class='login']")).click();

//      5.Verify the Text : CREATE AN ACCOUNT
        // 1st way
                Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='page-heading']")).isDisplayed());
        // 2nd way
                String createElement= driver.findElement(By.xpath("//h3[@class='page-subheading']")).getText();
                String expectedCreateElement="CREATE AN ACCOUNT";
                assertEquals(expectedCreateElement,createElement);

//      4.Send your email and click on create an account button.We will use that email. Make sure to save that email.
            String email= faker.internet().emailAddress();
            driver.findElement(By.id("email_create")).sendKeys(email);

        // click Create an account
            driver.findElement(By.xpath("//i[@class='icon-user left']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

//      6. Verify the Text : YOUR PERSONAL INFORMATION
            WebElement personalInfo= driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/h3"));
            String info=personalInfo.getText();
            assertEquals(info,"YOUR PERSONAL INFORMATION");

//      7. Verify the Text : Title
            String title=driver.findElement(By.xpath("//label[text()='Title']")).getText();
            System.out.println(title);
            assertEquals(title,"Title");

////    8. Select your title
            driver.findElement(By.xpath("//input[@id='id_gender1']")).click();

//      9. Enter your first name
            String firstName= faker.name().firstName();
            driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
//      10. Enter your last name
            String lastname= faker.name().lastName();
            driver.findElement(By.id("customer_lastname")).sendKeys(lastname);
//      11. Enter your email
            driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("email")).sendKeys(email);
//      12. Enter your password
            driver.findElement(By.id("passwd")).sendKeys(faker.internet().password());

//      13. ENTER DATE OF BIRTH
            WebElement day = driver.findElement(By.xpath("//select[@id='days']"));
            Select selectDay=new Select(day);
            selectDay.selectByIndex(11);
                WebElement month = driver.findElement(By.xpath("//select[@id='months']"));
                Select selectMonth=new Select(month);
                selectMonth.selectByIndex(1);
            WebElement years = driver.findElement(By.xpath("//select[@id='years']"));
            Select selectYear=new Select(years);
            selectYear.selectByValue("1997");

//      14. Click on Sign up for our newsletter!
            driver.findElement(By.xpath("//input[@name='newsletter']")).click();

//      15. Enter your first name
            driver.findElement(By.xpath("//input[@id='firstname']")).clear();
            driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);

//      16. Enter your last name
            driver.findElement(By.xpath("//input[@id='lastname']")).clear();
            driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastname);

//      17. Enter your company
            driver.findElement(By.xpath("//input[@id='company']")).sendKeys(faker.company().name());

//      18. Enter your Address
            driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(faker.address().streetAddress());
            driver.findElement(By.xpath("//input[@name='address2']")).sendKeys(faker.address().streetAddressNumber());

//      19. Enter your City
            driver.findElement(By.xpath("//input[@name='city']")).sendKeys(faker.address().city());

//      20. SELECT STATE
            WebElement elementState= driver.findElement(By.xpath("//select[@name='id_state']"));
            Select selectState=new Select(elementState);
            selectState.selectByVisibleText("Florida");

//      21. Enter Postal Code
            driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("75021");

//      22.SELECT COUNTRY
            WebElement elementCountry= driver.findElement(By.xpath("//select[@name='id_country']"));
            Select selectCountry= new Select(elementCountry);
            selectCountry.selectByValue("21");

//      23. Enter additional information
            driver.findElement(By.xpath("//textarea[@name='other']")).
                sendKeys("5.Verify the Text : CREATE AN ACCOUNT\n" +
                "6. Verify the Text : YOUR PERSONAL INFORMATION");

//      24. Enter home phone
            driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(faker.phoneNumber().subscriberNumber(9));

//      25. Enter mobile phone
            driver.findElement(By.xpath("//input[@name='phone_mobile']")).sendKeys(faker.phoneNumber().cellPhone());

//      26. Enter reference nameaddress for alias
            driver.findElement(By.xpath("//input[@name='alias']")).sendKeys(faker.address().streetAddress());

//      27. Click Register
            driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span")).click();

//      28. Then verify MY ACCOUNT is displayed on the home page-SEE BELOW IMAGE
            String myAccount= driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
            Assert.assertEquals("MY ACCOUNT",myAccount);
//      Bonus
            String infoAccount= driver.findElement(By.xpath("//p[@class='info-account']")).getText();
            Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.",infoAccount);
    }
}
