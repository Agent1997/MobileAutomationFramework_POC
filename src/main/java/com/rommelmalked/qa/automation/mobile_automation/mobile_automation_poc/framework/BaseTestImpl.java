package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver.DriverType;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver.MobileCapabilities;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver.MobileDriverManager;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.reports.ExtentReporter;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.server.AppiumServer;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.pageObjects.SamplePom;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.*;


/*
 *TODO Continue working on reporting.
 * Find a way to create a node for every testng test
 */
public class BaseTestImpl {
    protected String category;
    protected AppiumDriver<MobileElement> driver;
    private MobileDriverManager driverManager;
    protected SamplePom samplePom;
    private AppiumServer server;


    public AppiumDriver<MobileElement> getDriver(){
        return this.driver;
    }
    /*
    NOTE: You can try configuring / setting up selenium grid on Before Suite
     */
    @BeforeSuite
    public void setUpSuite() {
        System.out.println("Setting up suite");
    }

    @BeforeTest
    public void setUpTest() {
        System.out.println("Setting up test");
    }

    //Setting category here to be used by test classes to label tests
    @BeforeClass
    @Parameters({"category","platformName"})
    public void setupClass(String category,String platformName) {
        System.out.println("Setting up class");
        server = new AppiumServer(4444);
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
        driver = driverManager.getMobileDriver();
        samplePom = new SamplePom(driver);
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("Tear down class");
        driver.quit();
        server.stopServer();
    }

    @AfterTest
    public void tearDownTest() {
        System.out.println("Tear down test");
    }

    @AfterSuite
    public void tearDownSuite() {
        System.out.println("Tear down suite");
//        ExtentReporter.getExtentTestMap().forEach((key, value) -> System.out.println(key + " " + value));
        ExtentReporter.getExtentReports().flush();
    }

}
