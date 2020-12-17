package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.utilities.Utils;

import java.util.HashMap;
import java.util.Map;


/*
NOTE: To generate a failed test. Make sure to configure testng run configuration
Under Listeners, make sure to add "org.testng.reporters.FailedReporter". It should
generate a test-output directory with the testng-failed.xml
 */

public class ExtentReporter {
    private static final ExtentReports extentReports = generateReporter();
//    private static final ExtentReports extentReports = generateReporterWithFailedReports();
    private static final Map extentTestMap = new HashMap();
    private static final String reportsFolderLoc = "extentReports";
    private static final String baseFileName = "ExecutionReport_AllTests";
    private static final String baseFileNameFailed = "ExecutionReport_FailedTests";

    private static ExtentReports generateReporter() {
        ExtentReports reporter = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(Utils.getProjectDirectory() + reportsFolderLoc + "/" + Utils.generateFileName(baseFileName) + ".html");
        reporter.attachReporter(sparkReporter);
        return reporter;
    }

    private static ExtentReports generateReporterWithFailedReports(){
        ExtentReports reporter = new ExtentReports();
        ExtentSparkReporter sparkReporterAllTests= new ExtentSparkReporter(Utils.getProjectDirectory() + reportsFolderLoc + "/" + Utils.generateFileName(baseFileName) + ".html");


        ExtentSparkReporter sparkReporterFailedTests = new ExtentSparkReporter(Utils.getProjectDirectory() + reportsFolderLoc + "/" + Utils.generateFileName(baseFileNameFailed) + ".html")
                .filter()
                .statusFilter()
                .as(new Status[] { Status.FAIL })
                .apply();

        reporter.attachReporter(sparkReporterAllTests,sparkReporterFailedTests);

        return reporter;
    }

    public static ExtentReports getExtentReports() {
        return extentReports;
    }

    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (Thread.currentThread().getId()));
    }


    public static synchronized ExtentTest createTest(String testName) {
        ExtentTest test = extentReports.createTest(testName);
        extentTestMap.put((int) (Thread.currentThread().getId()), test);
        return test;
    }

    /*
    NOTE: All create test will be done in the listeners. But if you will use this, createTest should
    be used in test methods and all create test in the listeners should be removed.
    Will comment out this method for now. Uncomment it once usable.
     */

//    public static synchronized ExtentTest createTest(String testName, String description) {
//        ExtentTest test = extentReports.createTest(testName,description);
//        extentTestMap.put((int)(Thread.currentThread().getId()), test);
//        return test;
//    }

}
