package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.reporterTest;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.BaseTestImpl;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.reports.ExtentReporter;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ReporterTest5 extends BaseTestImpl {
    @Test
    public void ReporterTest5test1(){
        ExtentReporter.createTest("Test","ReporterTest5 sample test1",category);

        assertTrue(false);
    }

    @Test
    public void ReporterTest5test2(){
        ExtentReporter.createTest("Test","ReporterTest5 sample test2",category);
        assertTrue(true);
    }
}
