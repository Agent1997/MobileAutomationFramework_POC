package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.reporterTest;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.BaseTestImpl;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.reports.ExtentReporter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ReporterTest7 extends BaseTestImpl {


    @Test
    public void ReporterTest7test1(){
//        ExtentReporter.createTest("Test");
        ExtentReporter.getTest().assignAuthor("Rommel").assignCategory(category);

        assertTrue(false);
    }

    @Test
    public void ReporterTest7test2(){
//        ExtentReporter.createTest("Test");
        ExtentReporter.getTest().assignAuthor("Rommel").assignCategory(category);

        assertTrue(true);
    }
}

