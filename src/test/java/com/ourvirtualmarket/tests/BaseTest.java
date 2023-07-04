package com.ourvirtualmarket.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.microsoft.playwright.Page;
import com.ourvirtualmarket.utilities.Driver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTest {

    protected static Page page;
    protected ExtentReports extent;
    protected ExtentTest test;
    protected ExtentHtmlReporter htmlReporter;


    @BeforeTest
    public void beforeTest() {
        // ExtentReports nesnesini ve raporlayıcıyı oluşturma
        htmlReporter = new ExtentHtmlReporter("extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @BeforeClass
    public void setUp() {
        Driver.initialize();
        page = Driver.getPage();
    }

    @AfterClass
    public void tearDown() {
        Driver.close();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        // Her testin sonunda rapora sonucu ekleme
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());

            // Ekran görüntüsü alma ve rapora ekleme
            if (page != null) {
                String screenshotName = result.getName() + ".png";
                Path screenshotPath = Paths.get("screenshots", screenshotName);
                page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath));

                test.addScreenCaptureFromPath(screenshotPath.toString());
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip(result.getThrowable());
        } else {
            test.pass("Test passed");
        }
    }

    @AfterTest
    public void tearDownTest(){
        extent.flush();
    }


}
