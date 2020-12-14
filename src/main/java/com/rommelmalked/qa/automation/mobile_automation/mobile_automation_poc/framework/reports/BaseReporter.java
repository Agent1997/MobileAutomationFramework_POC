package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.reports;

import com.aventstack.extentreports.ExtentReports;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.utilities.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseReporter {
    private static ExtentReports extentReports = new ExtentReports();
    private DateFormat dateFormat = new SimpleDateFormat("ddMMMyyy_HH:mm:ss");
    private Date date = new Date();
    private String path = Utils.getProjectDirectory() + "/extentReports/" + dateFormat.format(date) + ".html";
}
