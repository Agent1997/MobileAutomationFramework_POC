package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.reports;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.utilities.Utils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


/*
TODO improver reporting
 find a way to get the name of the calling method
 work on handling test failed. getting screenshots
 work on being able to rerun failed test cases only
 try extent report filters
 beatutify reports
 see if we can deploy the test result to remote repository so that everyone can access the report on their web
 */
public class TestListenerImpl implements ITestListener{

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("onTestStart");
        ExtentReporter.createTest(Utils.getTestNGTestMethodName(iTestResult));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentReporter.getTest().pass("passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        ExtentReporter.getTest().fail("Failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("onTestSkipped");
        ExtentReporter.createTest(Utils.getTestNGTestMethodName(iTestResult));
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
