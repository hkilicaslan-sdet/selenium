package com.myfirstproject.Day02;

import org.junit.*;

public class Day02_JUnitAnnotations {
/*  @Test annotation is to create test cases.
        it helps to run test methods without main method !
    All test methods must be void

    @BeforeClass is used to run once before the entire class
        @BeforeClass is also used for PreConditions

    @AfterClass is used to run once after the entire class
        @AfterClass is also used for AfterConditions
Yasin
             @Test is used to create test cases.
     All test methods must be void
     We can not run methods without @Test
     @BeforeClass is used to run once before the entire class
        @BeforeClass is  also used for PreConditions
     @AfterClass is used to run once after the entire class
        @AfterClass is  also used for AfterConditions
 */
    @BeforeClass
    public static void setUpClass(){
        System.out.println("This is the @BeforeClass annotation !");
    }

    @AfterClass
    public static void closeDownClass(){
        System.out.println("This is the @AfterClass annotation !");
    }
    @Before
    public void setUpMethod(){
        System.out.println("This is the @Before annotation !");
    }
    @After
    public void closeDownMethod(){
        System.out.println("This is the @After annotation !");
    }

    @Test
    public void test1(){
        System.out.println("This is the Test1");
    }
    @Test
    public void test2(){
        System.out.println("This is the Test2");
    }
    @Test
    public void test3(){
        System.out.println("This is the Test3");
    }
    @Test
    public void test4(){
        System.out.println("This is the Test4");
    }
}
