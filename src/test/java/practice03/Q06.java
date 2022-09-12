package practice03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Q06 extends TestBase {
    @Test
    public void test(){
// Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        // Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();

        //additionFunction("9","3");
        //multiplicationFunction("9","8");
        //divisionFunction("65","5");
        subtractionFunction("45","32");

    }
    // ADDITION
    private void additionFunction(String x, String y) {
        WebElement selectFuncAdd= driver.findElement(By.id("function"));
        driver.findElement(By.id("number1")).sendKeys(x);
        driver.findElement(By.id("number2")).sendKeys(y);
        Select selectAddition=new Select(selectFuncAdd);
        selectAddition.selectByValue("plus");
        driver.findElement(By.id("calculate")).click();
        String additionResult= driver.findElement(By.xpath("//span[@id='answer']")).getText();
        System.out.println("additionResult :"+additionResult);
        Integer a= Integer.valueOf(x);
        Integer b= Integer.valueOf(y);
        Integer c= Integer.valueOf(additionResult);
        Assert.assertTrue(c ==(a+b));
    }

    // SUBTRACTION
    private void subtractionFunction(String x, String y) {
        WebElement selectFuncSubtract= driver.findElement(By.id("function"));
        driver.findElement(By.id("number1")).sendKeys(x);
        driver.findElement(By.id("number2")).sendKeys(y);
        Select selectMultiplication=new Select(selectFuncSubtract);
        selectMultiplication.selectByValue("minus");
        driver.findElement(By.id("calculate")).click();
        String subtractionResult= driver.findElement(By.xpath("//span[@id='answer']")).getText();
        System.out.println("subtractionResult :"+subtractionResult);
        Integer a= Integer.valueOf(x);
        Integer b= Integer.valueOf(y);
        Integer c= Integer.valueOf(subtractionResult);
        Assert.assertTrue(c ==(a-b));
    }

    // DIVISION
    private void divisionFunction(String x, String y) {
        WebElement selectFuncDivide= driver.findElement(By.id("function"));
        driver.findElement(By.id("number1")).sendKeys(x);
        driver.findElement(By.id("number2")).sendKeys(y);
        Select selectDıvision=new Select(selectFuncDivide);
        selectDıvision.selectByValue("divide");
        driver.findElement(By.id("calculate")).click();
        String disionResult= driver.findElement(By.xpath("//span[@id='answer']")).getText();
        System.out.println("disionResult :"+disionResult);
        Integer a= Integer.valueOf(x);
        Integer b= Integer.valueOf(y);
        Integer c= Integer.valueOf(disionResult);
        Assert.assertTrue(c ==(a/b));
    }

    // MULTIPLICATION
    private void multiplicationFunction(String x, String y) {
        WebElement selectFuncMultipl= driver.findElement(By.id("function"));
        driver.findElement(By.id("number1")).sendKeys(x);
        driver.findElement(By.id("number2")).sendKeys(y);
        Select selectSubtraction=new Select(selectFuncMultipl);
        selectSubtraction.selectByValue("times");
        driver.findElement(By.id("calculate")).click();
        String multiplicationResult= driver.findElement(By.xpath("//span[@id='answer']")).getText();
        System.out.println("multiplicationResult :"+multiplicationResult);
        Integer a= Integer.valueOf(x);
        Integer b= Integer.valueOf(y);
        Integer c= Integer.valueOf(multiplicationResult);
        Assert.assertTrue(c ==(a*b));
    }

}
