package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.aut.page_objects.SamplePom;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver.DriverType;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver.MobileCapabilities;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver.MobileDriverManager;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleTestAndroid {
    private AppiumDriver driver;
    private MobileDriverManager driverManager;
    private SamplePom samplePom;

    @BeforeClass
    public void setup(){
        MobileDriverManager driverManager = new MobileDriverManager(DriverType.ANDROID, MobileCapabilities.getIOSSimulatorCaps());
//        driverManager = new MobileDriverManager(DriverType.ANDROID, MobileCapabilities.getAndroidEmulatorCaps());
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
    }

}
