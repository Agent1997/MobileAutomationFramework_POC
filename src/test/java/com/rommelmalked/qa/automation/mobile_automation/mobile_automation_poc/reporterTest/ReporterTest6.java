package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.reporterTest;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.BaseTestImpl;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.reports.ExtentReporter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ReporterTest6 extends BaseTestImpl {
    @Test
    public void ReporterTest6test1(){
        ExtentReporter.createTest("testName","ReporterTest6 sample test1",category);

        assertTrue(false);
    }

    @Test
    public void ReporterTest6test2(){
        ExtentReporter.createTest("testName","ReporterTest6 sample test2",category);
        assertTrue(true);
    }
}
