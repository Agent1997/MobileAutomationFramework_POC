package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.reporterTest;


import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.BaseTestImpl;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.reports.ExtentReporter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

//@Listeners(ITestListenerImpl.class)
public class ReporterTest1 extends BaseTestImpl {
//    @BeforeSuite
//    public void beforeSuite(){
//        System.out.println("ReporterTest1: BEFORE SUITE");
//    }
//
//    @BeforeTest
//    public void beforeTest(){
//        System.out.println("ReporterTest1: BEFORE TEST");
//    }
//
//    @BeforeClass
//    public void beforeClass(){
//        System.out.println("ReporterTest1: BEFORE CLASS");
//    }
//
//    @BeforeMethod
//    public void beforeMethod(){
//        System.out.println("ReporterTest1: BEFORE METHOD");
//    }
//


    @Test
    public void test1(){
        ExtentReporter.createTest("Test","sample test1",category);

        assertTrue(false);
    }

    @Test
    public void test2(){
        ExtentReporter.createTest("Test","sample test1",category);
        assertTrue(true);
    }

//    @Test
//    public void test2(){
//        assertTrue(true);
//    }

//    @AfterSuite
//    public void afterSuite(){
//        System.out.println("ReporterTest1: AFTER SUITE");
//    }
//
//    @AfterTest
//    public void afterTest(){
//        System.out.println("ReporterTest1: AFTER TEST");
//    }
//
//    @AfterClass
//    public void afterClass(){
//        System.out.println("ReporterTest1: AFTER CLASS");
//    }
//
//    @AfterMethod
//    public void afterMethod(){
//        System.out.println("ReporterTest1: AFTER METHOD");
//    }


}