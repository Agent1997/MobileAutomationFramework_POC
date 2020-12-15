package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.reports.ExtentReporter;
import org.testng.annotations.*;


/*
 *TODO Continue working on reporting.
 * Find a way to create a node for every testng test
 */
public class BaseTestImpl {
    protected String category;

    /*
    NOTE: You can try configuring / setting up selenium grid on Before Suite
     */
    @BeforeSuite
    public void setUpSuite() {
        System.out.println("Setting up suite");
    }

    @BeforeTest
    public void setUpTest() {
        System.out.println("Setting up test");
    }

    @BeforeClass
    @Parameters("category")
    public void setupClass(String category) {
        System.out.println("Setting up class");
        this.category = category;


    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("Tear down class");
    }

    @AfterTest
    public void tearDownTest() {
        System.out.println("Tear down test");
    }

    @AfterSuite
    public void tearDownSuite() {
        System.out.println("Tear down suite");
        ExtentReporter.getExtentReports().flush();
    }

}
