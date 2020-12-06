package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportManager {

    public static ExtentReports getReporter() {
        ExtentReports reporter = new ExtentReports();
        DateFormat dateFormat = new SimpleDateFormat("ddMMMyyy_HH:mm:ss");
        Date date = new Date();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/extentReports/" + dateFormat.format(date) + ".html");
        reporter.attachReporter(sparkReporter);
        return reporter;
    }

}
