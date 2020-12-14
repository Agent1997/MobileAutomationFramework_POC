package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.utilities.Utils;
import org.testng.annotations.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
 *TODO Continue working on reporting. Find out a way to generate a single report for one
 * suite with with multiple test and multiple classes inside that test.
 */
public class BaseTest implements IBaseTest {

    protected ExtentReports extentReports;
    private DateFormat dateFormat = new SimpleDateFormat("ddMMMyyy_HH:mm:ss");
    private Date date;
    private String path;

    @BeforeSuite
    @Override
    public void setUpSuite() {
        System.out.println("Setting up suite");
        this.extentReports = new ExtentReports();
        this.date = new Date();
        this.path = Utils.getProjectDirectory() + "/extentReports/" + dateFormat.format(date) + ".html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        this.extentReports.attachReporter(sparkReporter);
    }

    @BeforeTest
    @Override
    public void setUpTest() {
        System.out.println("Setting up test");
    }

    @BeforeClass
    @Override
    public void setupClass() {
        System.out.println("Setting up class");
        this.extentReports.createTest("test").pass("passed");
    }

    @AfterClass
    @Override
    public void tearDownClass() {
        System.out.println("Tear down class");
        this.extentReports.createTest("test").pass("passed");
    }

    @AfterTest
    @Override
    public void tearDownTest() {
        System.out.println("Tear down test");
    }

    @AfterSuite
    @Override
    public void tearDownSuite() {
        System.out.println("Tear down suite");
        this.extentReports.flush();
    }

    protected ExtentReports getExtentReports() {
        return this.extentReports;
    }
}
