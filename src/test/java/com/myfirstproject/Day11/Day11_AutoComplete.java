package com.myfirstproject.Day11;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Day11_AutoComplete extends TestBase {
    @Test
    public void autocompleteTest(){
        driver.get("https://jqueryui.com/autocomplete/");
        driver.switchTo().frame(0);
        WebElement inputBox= driver.findElement(By.id("tags"));
        inputBox.sendKeys("Apple");

// 'ui-menu-item' class appears only after beginning to type
    // a good manual exploration must be made before automation

        WebElement suggestion= driver.findElement(By.className("ui-menu-item"));
    //    suggestion.click();

// doing it by JS
        clickByJS(suggestion);
    }

    @Test
    public void autocompleteTest2(){
        driver.get("https://jqueryui.com/autocomplete/");
        driver.switchTo().frame(0);
        WebElement inputBox= driver.findElement(By.id("tags"));
        inputBox.sendKeys("a");

// 'ui-menu-item' class appears only after beginning to type
        // a good manual exploration must be made before automation

        List<WebElement> suggestions= driver.findElements(By.className("ui-menu-item"));
        for (WebElement each:suggestions ) {
            System.out.println("suggestions : "+each.getText());
            if (each.getText().equals("Fortran")){
                each.click();
                break;
            }
        }
    }
}
