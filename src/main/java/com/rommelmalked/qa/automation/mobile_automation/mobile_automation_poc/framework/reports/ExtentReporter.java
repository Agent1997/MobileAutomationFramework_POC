package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExtentReporter {
    private static ExtentReports extentReports = generateReporter();
    private static Map extentTestMap = new HashMap();

    private static ExtentReports generateReporter(){
        ExtentReports reporter = new ExtentReports();
        DateFormat dateFormat = new SimpleDateFormat("ddMMMyyy_HH:mm:ss");
        Date date = new Date();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/extentReports/" + dateFormat.format(date) + ".html");
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



}
