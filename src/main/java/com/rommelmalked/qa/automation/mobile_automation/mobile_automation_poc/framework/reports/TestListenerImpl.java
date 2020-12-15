package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.reports;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.BaseTestImpl;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenerImpl extends BaseTestImpl implements ITestListener{
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("onTestSuccess");
        ExtentReporter.getTest().pass("passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("onTestFailure");
        ExtentReporter.getTest().fail("Failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("onTestSkipped");
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
