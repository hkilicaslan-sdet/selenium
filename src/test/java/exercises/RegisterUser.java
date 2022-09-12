package exercises;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterUser extends TestBase {
    @Test
    public void test(){
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        Faker faker=new Faker();
//3. Verify that home page is visible successfully
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");

//4. Click on 'Signup / Login' button
        WebElement login=driver.findElement(By.xpath("//a[@href='/login']"));
        login.click();
//5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[.='New User Signup!']")).isDisplayed());

//6. Enter name and email address

        String fullName= faker.name().fullName();
                driver.findElement(By.xpath("//input[@name='name']")).sendKeys(fullName);

        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(faker.internet().emailAddress());
//7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[.='Enter Account Information']")).isDisplayed());


//9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//label[@for='id_gender1']")).click();

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");

        WebElement dropDownDay= driver.findElement(By.id("days"));
        Select selectDay=new Select(dropDownDay);
        selectDay.selectByValue("11");

        WebElement dropDownMonth= driver.findElement(By.id("months"));
        Select selectMonth=new Select(dropDownMonth);
        selectMonth.selectByValue("5");

        WebElement dropDownYear= driver.findElement(By.id("years"));
        Select selectYear=new Select(dropDownYear);
        selectYear.selectByValue("1997");


//10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();

//11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();

//12. Fill details: First name, Last name, Company, Address, Address2,

        driver.findElement(By.id("first_name")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("last_name")).sendKeys(faker.name().lastName());
        driver.findElement(By.id("company")).sendKeys(faker.company().name());
        driver.findElement(By.id("address1")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.id("address2")).sendKeys(faker.address().streetAddressNumber());
    // Country, State, City, Zipcode, Mobile Number
        WebElement dropCountry=driver.findElement(By.id("country"));
        Select country=new Select(dropCountry);
        country.selectByVisibleText("Canada");

        driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys(faker.address().state());
        driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys(faker.address().city());
        driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys(faker.address().zipCode());
        driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys(faker.phoneNumber().cellPhone());

//13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

//14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[.='Account Created!']")).isDisplayed());
//15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

//16. Verify that 'Logged in as username' is visible
        WebElement loggedIn=driver.findElement((By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/.")));
        System.out.println(loggedIn.getText());
        Assert.assertTrue(loggedIn.isDisplayed());



//17. Click 'Delete Account' button
       // driver.findElement(By.linkText(" Delete Account")).click();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).click();

//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button


    }

}
