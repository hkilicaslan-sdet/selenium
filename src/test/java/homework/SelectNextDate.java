package homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelectNextDate extends TestBase {
    @Test
    public void selectNextDay() {
        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(0);
// select the next day
        WebElement datePicker=driver.findElement(By.xpath("//input[@id='datepicker']"));
            datePicker.click();
        WebElement nextDay=  driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight']//following::a[@data-date=.]"));
        nextDay.click();
        getValueByJS("datepicker");
    }
}

//        WebElement actualDate=  driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight']"));
//        actualDate.click();
//        String value =getValueByJS("datepicker");


//
//        LocalDate tomorrow= LocalDate.now().plusDays(1);
//        System.out.println("Tomorrow : "+ tomorrow);

//
//        WebElement actualDate2=  driver.findElement(By.xpath("//a[@data-date=.]"));
//        //     unique for 30 days  : //a[@data-date=.]
//        String date1=driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight']")).getText();
//        String date2=  driver.findElement(By.xpath("//a[@data-date=.]")).getText();
//        System.out.println(date1);
//        System.out.println(date2);
//

