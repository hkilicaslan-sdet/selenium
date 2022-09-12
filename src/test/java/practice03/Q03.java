package practice03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Q03 extends TestBase {
    @Test
    public void test(){
//     * Navigate to  https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");

//     * Enter the username  as "standard_user"
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

//     * Enter the password as   "secret_sauce"
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

//     * Click on login button
        driver.findElement(By.id("login-button")).click();
//     * Order products by "Price (low to high)"
        WebElement dropDown= driver.findElement(By.className("product_sort_container"));
        Select select=new Select(dropDown);
        select.selectByValue("lohi");

//     Verify that last product costs $49.99, first product costs $7.99.
      List<WebElement> productList=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (WebElement each:productList  ) {
            each.getText();
            System.out.println(each.getText());
        }
        Assert.assertEquals("$7.99", productList.get(0).getText());
        Assert.assertEquals("$49.99", productList.get(productList.size()-1).getText());
        driver.quit();
    }
}
