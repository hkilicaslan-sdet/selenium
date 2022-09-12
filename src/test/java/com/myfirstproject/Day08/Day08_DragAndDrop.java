package com.myfirstproject.Day08;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day08_DragAndDrop extends TestBase {
    @Test
    public void dragAndDrop(){
//        Create a class: Action4
//        Create a method dragAndDropTest
//        Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        Actions actions=new Actions(driver);
//        And user moves the target element(Drag me to my target) in to destination(Drop here)
        driver.switchTo().frame(0);
// locating source & target
        WebElement drag=driver.findElement(By.id("draggable"));
        WebElement drop=driver.findElement(By.id("droppable"));
// doing ACTION drag & drop
        actions.dragAndDrop(drag,drop).perform();
    }
    @Test
    public void clickAndHoldTest(){
//  Create a class: Action4
//  Create a method dragAndDropTest
//  Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        Actions actions=new Actions(driver);
//  And user moves the target element(Drag me to my target) in to destination(Drop here)
        driver.switchTo().frame(0);
//  locating source & target
        WebElement drag=driver.findElement(By.id("draggable"));
        WebElement drop=driver.findElement(By.id("droppable"));

// doing ACTION clickAndHold
        actions.clickAndHold(drag).moveToElement(drop).perform();
    // mooving by coordinates
         actions.clickAndHold(drag).moveByOffset(464,-22).build().perform();
        //      actions.clickAndHold(drag).moveByOffset(156,27).perform();
    }
}
