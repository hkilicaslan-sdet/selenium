package com.myfirstproject.Day10_ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Day10_ExtentReports extends TestBase {

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;    // same with ; protected ExtentTest logger;

    @BeforeClass
    public static void extentSetup(){
// we will create a report here REPORT PATH

        String currentTime=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";

// creating html report in the path
        extentHtmlReporter=new ExtentHtmlReporter(path);

// creating extent reports object for generating some configurations
        extentReports=new ExtentReports();

//      *********** CONFIGURATIONS*********************

// adding some custom info with extentReports
        extentReports.setSystemInfo("Test Environment", "Regression");
        extentReports.setSystemInfo("Application", "Techproed");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Team", "Eagles");
        extentReports.setSystemInfo("SQA", "John Fox");

// adding more custom info with extentHtmlReporter
        extentHtmlReporter.config().setReportName("TechproEd Home page");
        extentHtmlReporter.config().setDocumentTitle("TechproEd extent Reports");

//      *********** CONFIGURATIONS*********************

//  DONE WITH CONFIGURATION
//  extentReports & extentHtmlReporter need to be connected
        extentReports.attachReporter(extentHtmlReporter);

//  REPORT IS DONE ; CREATING EXTENT TEST TO LOG INFI INTO THE TEST CASE

// creating extent test
        extentTest= extentReports.createTest("My Extext Reporter", "Regression Test Report");
    }

    @Test
    public void extentReportsTest(){



//  DONE WITH REPORT SETUP. FROM NOW ON USE extentTest object TO LOG INFORMATION

        extentTest.pass("PASS");
        extentTest.info("INFO");
        extentTest.fail("FAIL");
        extentTest.skip("SKIP");
        extentTest.warning("WARNING");


        extentTest.pass("Going to the Application url.");
        driver.get("https://www.techproeducation.com");
        extentTest.pass("Opened the default page");
        extentTest.pass("Searching QA on the web page");
        driver.findElement(By.xpath(".//input[@type='search']")).sendKeys("QA", Keys.ENTER);

        extentTest.pass("Verifying 'QA' exist in the part of url");
        Assert.assertTrue(driver.getCurrentUrl().contains("QA"));

        extentTest.pass("Closing the browser");
        driver.quit();



// closing and generating the report
        extentReports.flush();

    }
}
