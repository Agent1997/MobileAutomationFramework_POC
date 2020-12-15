package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.reporterTest;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.BaseTestImpl;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.reports.ExtentReporter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ReporterTest4 extends BaseTestImpl {
    @Test
    public void test1(){
        ExtentReporter.createTest("Test","sample test1");
        assertTrue(false);
    }

    @Test
    public void test2(){
        ExtentReporter.createTest("Test","sample test1");
        assertTrue(true);
    }
}
