package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.test;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver.MobileCapabilities;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver.MobileDriverManagerStatic;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.server.AppiumServer;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.pageObjects.SamplePom;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Test2 {
    public static void main(String[] args) {
        AppiumServer server = new AppiumServer();
//        MobileDriverManager driverManager = new MobileDriverManager(DriverType.ANDROID, MobileCapabilities.getAndroidEmulatorCaps(),server.getServer());
//        AppiumDriver<MobileElement> driver =  driverManager.getMobileDriver();
        AppiumDriver<MobileElement> driver = MobileDriverManagerStatic.getMobileDriver(MobileCapabilities.getAndroidEmulatorCaps(),server.getServer());
        SamplePom samplePom = new SamplePom(driver);
        samplePom.clickButton();
//        driverManager.quitMobileDriver();
        driver.quit();
        server.stopServer();

    }
}
