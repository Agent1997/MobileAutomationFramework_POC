package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.test;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver.DriverType;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver.MobileCapabilities;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver.MobileDriverManager;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.server.AppiumServer;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.page_objects.SamplePom;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 *For demo only
 */

public class SampleTest {
    private AppiumDriver driver;
    private MobileDriverManager driverManager;
    private SamplePom samplePom;
    private AppiumServer server;

    @Parameters("platformName")
    @BeforeClass
    public void setup(String platformName){
        server = new AppiumServer();
        server.startServer();
        if(platformName.equalsIgnoreCase("android")){
            driverManager = new MobileDriverManager(DriverType.ANDROID, MobileCapabilities.getAndroidEmulatorCaps(),server.getServer());
            System.out.println(platformName);
        }
        if(platformName.equalsIgnoreCase("ios")){
            driverManager = new MobileDriverManager(DriverType.IOS, MobileCapabilities.getIOSSimulatorCaps(),server.getServer());
            System.out.println(platformName);
        }
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
        server.stopServer();
    }

}
