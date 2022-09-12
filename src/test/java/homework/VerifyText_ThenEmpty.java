package homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class VerifyText_ThenEmpty extends TestBase {
    @Test
    public void verifyText_ThenEmpty() throws InterruptedException {
        driver.get("https://jqueryui.com/toggle/");
// print the text appeared
        driver.switchTo().frame(0);
        String text1=driver.findElement(By.xpath("//div[@id='effect']/p")).getText();
        System.out.println("Text 1 : "+text1);

// click on Run Effect Button
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='button']")).click();
            //String text2=driver.findElement(By.xpath("//div[@id='effect']/p")).getText(); Text 2 lenght: 138
            // we need to locate the new situation again
        String text2=driver.findElement(By.xpath("//div[@style='display: none;']")).getText();
        System.out.println("Text 2 : "+text2);
    // verify the text is empty
        int a =text2.length();
        System.out.println("Text 2 lenght: "+a);
        Assert.assertTrue(a==0);

// click on Run Effect Button
// Then print the text "Etiam libero neque, luctus a, eleifend nec, semper at, lorem.
    // Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi."
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='button']")).click();
        String text3=driver.findElement(By.xpath("//div[@id='effect']/p")).getText();
        System.out.println("Text 3 : "+text3);

// click on Run Effect Button
    // and verify it is empty...
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='button']")).click();
        String text4=driver.findElement(By.xpath("(//div[@style='display: none;'])[1]")).getText();
    // verify the text is empty
        int b=text4.length();
        System.out.println("Text 4 lenght: "+b);
        Assert.assertTrue(b==0);

// click on Run Effect Button
// Then verify the text is appeared again
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='button']")).click();
        String text5=driver.findElement(By.xpath("//div[@id='effect']/p")).getText();
        System.out.println("Text 5 : "+text5);
// Note : hard wait can be used if needed.
    }
}
