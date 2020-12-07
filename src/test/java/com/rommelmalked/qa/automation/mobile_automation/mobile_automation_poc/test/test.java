package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.test;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.selenium_grid.SeleniumGrid;

public class test {
    public static void main(String[] args) {
        SeleniumGrid sg = new SeleniumGrid();
        sg.startSeleniumGrid();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sg.stopSeleniumGrid();
    }
}
