package com.myfirstproject.Day07;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day07_Cookies extends TestBase {

//-Go to amazon and automate the tasks:
//1. Find the total number of cookies
//2. Print all the cookies
//3. Get the cookies by their name
//4. Add new cookie
//5. Delete cookie by name
//6. Delete all of the cookies
    @Test
    public void test(){
//-Go to amazon and automate the tasks:
        driver.get("https://www.amazon.com");

//1. Find the total number of cookies
        Set<Cookie> allCookies=driver.manage().getCookies();
        System.out.println("Number of All cookies : " +allCookies.size());

//2. Print all the cookies
        for (Cookie w: allCookies  ) {
            System.out.println("All cookies : "+w);
        }

        for (Cookie x: allCookies  ) {
            System.out.println("All cookie names : "+x.getName());
                    //            All cookie names : sp-cdn
                    //            All cookie names : i18n-prefs
                    //            All cookie names : ubid-main
                    //            All cookie names : session-id-time
                    //            All cookie names : skin
                    //            All cookie names : csm-hit
                    //            All cookie names : session-id
        }

        for (Cookie y: allCookies  ) {
            System.out.println("All cookie values : "+y.getValue());

        }

//3. Get the cookies by their name
        Cookie namesCookie = driver.manage().getCookieNamed("ubid_main");

//4. Add new cookie
        Cookie myCookie=new Cookie("My-Fav-Cookie","Kavala");
        driver.manage().addCookie(myCookie);
        System.out.println("Number of new All cookies : " +driver.manage().getCookies().size());

//5. Delete cookie by name
        driver.manage().deleteCookieNamed("skin");
        System.out.println("size after deleting : "+driver.manage().getCookies().size());

//6. Delete all of the cookies
        driver.manage().deleteAllCookies();
        System.out.println("size after deleting all : "+driver.manage().getCookies().size());

    }

}
