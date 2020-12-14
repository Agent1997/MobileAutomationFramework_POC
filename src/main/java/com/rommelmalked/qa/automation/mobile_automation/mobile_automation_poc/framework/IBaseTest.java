package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework;

import org.testng.annotations.*;

public interface IBaseTest {
    @BeforeSuite
     void setUpSuite();

    @BeforeTest
     void setUpTest();

    @BeforeClass
     void setupClass();

    @AfterClass
     void tearDownClass();

    @AfterTest
    void tearDownTest();

    @AfterSuite
    void tearDownSuite();
}
