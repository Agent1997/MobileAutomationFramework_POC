package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.test;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.BaseTestImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 *For demo only
 */

public class SampleTest extends BaseTestImpl {
//    private AppiumDriver<MobileElement> driver;
//    private MobileDriverManager driverManager;
//    private SamplePom samplePom;
//    private AppiumServer server;

//    @Parameters("platformName")
//    @BeforeClass
//    public void setup(String platformName){
//        server = new AppiumServer(4444);
//        server.startServer();
//        if(platformName.equalsIgnoreCase("android")){
//            driverManager = new MobileDriverManager(DriverType.ANDROID, MobileCapabilities.getAndroidEmulatorCaps(),server.getServer());
//            System.out.println(platformName);
//        }
//        if(platformName.equalsIgnoreCase("ios")){
//            driverManager = new MobileDriverManager(DriverType.IOS, MobileCapabilities.getIOSSimulatorCaps(),server.getServer());
//            System.out.println(platformName);
//        }
////        driverManager = new MobileDriverManager(DriverType.ANDROID, MobileCapabilities.getAndroidEmulatorCaps());
//        driver = driverManager.getMobileDriver();
//        samplePom = new SamplePom(driver);
//    }


    @Test
    public void sampleTestRun(){
        samplePom.clickButton();
        assertTrue(false);
    }

    @Test
    public void sampleTestRun1(){
        assertTrue(true);
    }

//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//        server.stopServer();
//    }

}
