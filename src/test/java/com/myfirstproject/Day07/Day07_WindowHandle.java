package com.myfirstproject.Day07;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.WindowType;

public class Day07_WindowHandle extends TestBase {

    @Test
    public void newWindowTest() throws InterruptedException {
// open 3 different pages and verify their URLs

        driver.get("https://www.techproeducation.com");
        String techproTitle =driver.getTitle();
        System.out.println("Techpro Title : "+techproTitle);
        String techproHandle=driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinTitle=driver.getTitle();
        System.out.println("Linkedin Title : "+linkedinTitle);
        String linkedinHandle=driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.com");
        String amazonTitle =driver.getTitle();
        System.out.println("Amazon Title : "+ amazonTitle);
        String amazonHandle=driver.getWindowHandle();

        Thread.sleep(2000);
        driver.switchTo().window(techproHandle);

        Thread.sleep(2000);
        driver.switchTo().window(amazonHandle);

        Thread.sleep(2000);
        driver.switchTo().window(linkedinHandle);

        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void  test2() throws InterruptedException {

        driver.get("https://www.techproeducation.com");
        String techproTitle =driver.getTitle();
        System.out.println("Techpro Title : "+techproTitle);
        String techproHandle=driver.getWindowHandle();

    // open LMS on new tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://lms.techproeducation.com");
        String lmsTitle =driver.getTitle();
        System.out.println("LMS Title : "+lmsTitle);
        String lmsHandle=driver.getWindowHandle();

        Thread.sleep(3000);
        driver.switchTo().window(techproHandle);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");
        String youtubeTitle =driver.getTitle();
        System.out.println("YouTube Title : "+youtubeTitle);
        String youTubeHandle=driver.getWindowHandle();

        Thread.sleep(3000);
        driver.switchTo().window(lmsHandle);

        Thread.sleep(3000);
        driver.quit();

    }
}
