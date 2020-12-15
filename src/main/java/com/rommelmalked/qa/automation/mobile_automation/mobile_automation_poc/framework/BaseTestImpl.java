package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.reports.ExtentReporter;
import org.testng.annotations.*;


/*
 *TODO Continue working on reporting. Find out a way to generate a single report for one
 * suite with with multiple test and multiple classes inside that test.
 * Checkout Testng lifecycle
 */
public class BaseTestImpl implements IBaseTest {

    /*
    NOTE: You can try configuring / setting up selenium grid on Before Suite
     */
    @BeforeSuite
    @Override
    public void setUpSuite() {
        System.out.println("Setting up suite");
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
//        this.extentReports.createTest("test").pass("passed");
    }

    @AfterClass
    @Override
    public void tearDownClass() {
        System.out.println("Tear down class");
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
        ExtentReporter.getExtentReports().flush();
    }

}
