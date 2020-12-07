package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import lombok.Getter;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 *For demo only
 */

@Getter
public class MobileDriverManager {
    private AppiumDriver driver;
    private DriverType driverType;
    private static final String DEFAULT_LOCAL_URL = "http://127.0.0.1:4723/wd/hub";

    public MobileDriverManager(DriverType driverType, HashMap<String,Object> caps){
        try {
            driver = new AppiumDriver(new URL(DEFAULT_LOCAL_URL),setCapsFromHashMap(caps));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        this.driverType = driverType;
    }

    public MobileDriverManager(DriverType driverType, HashMap<String,Object> caps, AppiumDriverLocalService server){
            driver = new AppiumDriver(server,setCapsFromHashMap(caps));
        this.driverType = driverType;
    }

    private  DesiredCapabilities setCapsFromHashMap(HashMap<String,Object> caps){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        for(String key : caps.keySet()){
            capabilities.setCapability(key,caps.get(key));
        }
        return capabilities;
    }

    public void quitMobileDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

}
