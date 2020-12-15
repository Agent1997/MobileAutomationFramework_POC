package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.utilities.Utils;

import java.util.HashMap;
import java.util.Map;

public class ExtentReporter {
    private static ExtentReports extentReports = generateReporter();
    private static Map extentTestMap = new HashMap();
    private static final String reportsFolderLoc = "extentReports";
    private static final String baseFileName = "ExecutionReport";

    private static ExtentReports generateReporter(){
        ExtentReports reporter = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(Utils.getProjectDirectory() + reportsFolderLoc + "/" + Utils.generateFileName(baseFileName) + ".html");
        reporter.attachReporter(sparkReporter);
        return reporter;
    }

    public static ExtentReports getExtentReports(){
        return extentReports;
    }

    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int)(Thread.currentThread().getId()));
    }

    public static synchronized ExtentTest createTest(String testName, String desc) {
        ExtentTest test = extentReports.createTest(testName, desc);
        extentTestMap.put((int)(Thread.currentThread().getId()), test);
        return test;
    }

    public static synchronized ExtentTest createTest(String testName, String desc, String categoryName) {
        ExtentTest test = extentReports.createTest(testName, desc).assignCategory(categoryName);
        extentTestMap.put((int)(Thread.currentThread().getId()), test);
        return test;
    }




}
