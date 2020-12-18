package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.test;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.BaseTestImpl;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.pageObjects.AssertInConst;
import org.testng.annotations.Test;

public class Test2 extends BaseTestImpl {
//    private static int number;

//    public static void main(String[] args) {
//        AppiumServer server = new AppiumServer();
//        MobileDriverManager driverManager = new MobileDriverManager(DriverType.ANDROID, MobileCapabilities.getAndroidEmulatorCaps(),server.getServer());
//        AppiumDriver<MobileElement> driver =  driverManager.getMobileDriver();
//        AppiumDriver<MobileElement> driver = MobileDriverManagerStatic.getMobileDriver(MobileCapabilities.getAndroidEmulatorCaps(),server.getServer());
//        SamplePom samplePom = new SamplePom(driver);
//        samplePom.clickButton();
//        driverManager.quitMobileDriver();
//        driver.quit();
//        server.stopServer();

//        for(int i = 0; i < 5; i++){
//            number = i;
//            System.out.println(number);
//        }

//    }

    @Test
    public void sampletest(){
        AssertInConst assertInConst = new AssertInConst();
    }


}
