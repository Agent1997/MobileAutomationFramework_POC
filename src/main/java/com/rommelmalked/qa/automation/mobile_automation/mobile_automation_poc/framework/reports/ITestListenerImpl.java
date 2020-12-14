package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.reports;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerImpl extends BaseTest implements ITestListener{
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("onTestSuccess");
        getExtentReports().createTest("test").pass("passed");
//        extentReports.createTest("Test").pass("passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("onTestFailure");
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
