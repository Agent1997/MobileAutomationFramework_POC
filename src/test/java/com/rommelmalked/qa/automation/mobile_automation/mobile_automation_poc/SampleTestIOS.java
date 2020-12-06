package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.page_objects.SamplePom;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver.DriverType;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver.MobileCapabilities;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver.MobileDriverManager;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.server.AppiumServer;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleTestIOS {
    private AppiumDriver driver;
    private MobileDriverManager driverManager;
    private SamplePom samplePom;
    private AppiumServer server;

    @BeforeClass
    public void setup(){
        server = new AppiumServer();
        server.startServer();
        MobileDriverManager driverManager = new MobileDriverManager(DriverType.ANDROID, MobileCapabilities.getIOSSimulatorCaps(),server.getServer());
//        MobileDriverManager driverManager = new MobileDriverManager(DriverType.ANDROID, MobileCapabilities.getIOSSimulatorCaps());
        driver = driverManager.getDriver();
        samplePom = new SamplePom(driver);
    }

    @Test
    public void sampleTestRun(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        samplePom.clickButton();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        server.stopServer();
    }
}
