package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.test;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.seleniumGrid.SeleniumGridHub;

public class test {
    public static void main(String[] args) {
        SeleniumGridHub sg = new SeleniumGridHub();
        sg.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        sg.stop();
    }
}
