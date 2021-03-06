package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.reports.ExtentReporter;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.utilities.Utils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


/*
TODO improve reporting
 beautify reports
 see if we can deploy the test result to remote repository so that everyone can access the report on their web
 Reports already good.
 */
public class TestListenerImpl extends BaseTestImpl implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        ExtentReporter.createTest(Utils.getTestNGTestMethodName(iTestResult));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentReporter.getTest().pass("passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Utils.getAndSaveScreenShot(iTestResult,"Screenshots",Utils.getTestNGTestMethodName(iTestResult));
        //ExtentReports log and screenshot operations for failed tests.
        ExtentReporter.getTest().fail( Utils.getThrownAssertionError(iTestResult),Utils.getBase64ScreenShotMedia(iTestResult));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("onStart");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("onFinnish");
    }
}
