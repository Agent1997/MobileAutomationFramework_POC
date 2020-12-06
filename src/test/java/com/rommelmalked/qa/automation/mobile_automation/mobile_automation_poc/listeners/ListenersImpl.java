package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.reports.ReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImpl implements ITestListener {
    private final ExtentReports extentReports = ReportManager
            .getReporter();

    private String getClassName(String fqdn) {
        String[] arr = fqdn.split("[.]");
        int index = arr.length - 1;
        return arr[index];
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentReports.createTest(getClassName(result.getTestClass().getName()) + "." + result.getName()).log(Status.PASS, "PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentReports.createTest(getClassName(result.getTestClass().getName()) + "." + result.getName()).log(Status.FAIL, result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
