package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.frameworkTest;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.seleniumGrid.SeleniumGridHub;

public class SeleniumGridHubTest {
    public static void main(String[] args) {
        SeleniumGridHub seleniumGridHub = new SeleniumGridHub();
        seleniumGridHub.start();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        seleniumGridHub.stop();
    }
}
