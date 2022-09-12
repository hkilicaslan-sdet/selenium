package homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonDropdown extends TestBase {
    @Test
    public void dropdownTest(){
// create amazonDropdown class
// create dropdownTest
// go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getCurrentUrl());

// locate the dropdown element and go there
// print the first selected and assert it if equals to "All Departments"
        WebElement dropDown= driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropDown);
            String first=select.getFirstSelectedOption().getText();
        System.out.println(first);
        Assert.assertEquals("All Departments",first);

// select the sixth option by index (5) and assert it if equals to "Books"
        List<WebElement> allOptions=select.getOptions();
        String sixth=allOptions.get(5).getText();
        Assert.assertEquals("Books",sixth);

// print all of the dropdown options getOptions() : method returns the List<WebElement> ;
        //  using loop print all options.
        List<WebElement> list=select.getOptions();

        List<String> originalList=new ArrayList<>();
        List<String> sortedList=new ArrayList<>();
        for ( WebElement w:list       ) {
            originalList.add(w.getText());
            sortedList.add(w.getText());
        }
        Collections.sort(sortedList);

        System.out.println("Original List : "+originalList);
        System.out.println("Sorted List : "+ sortedList);

// print he number of the total number of options in the dropdown
        System.out.println(list.size());

// assert if "Appliances" is a dropdown option.
            if (list.contains("Appliances")){
                System.out.println("Appliances among the dropdown elements ==> True");
            }else {
                System.out.println("Appliances among the dropdown elements ==> False");
            }
// BONUS : assert if the dropdown is in alphabetic order

        Assert.assertTrue(originalList.equals(sortedList));
            String result=originalList.equals(sortedList)
                    ?"OriginalList is equal to sortedList in alphabetic order"
                    :"=riginalList is NOT equal to sortedList in alphabetic order" ;

        System.out.println(result);

    }
}
