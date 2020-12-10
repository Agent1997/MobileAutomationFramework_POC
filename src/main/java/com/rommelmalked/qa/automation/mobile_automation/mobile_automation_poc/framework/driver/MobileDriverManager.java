package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * @author Agent1997
 */

/*
TODO Improve this class.
 Look on other possible way of creating the driver.
 Work on how to check the host where the server is running.
 */
public class MobileDriverManager {
    private AppiumDriver<MobileElement> driver;
    private final DriverType driverType;
    private AppiumDriverLocalService server;
    private static final String DEFAULT_LOCAL_URL = "http://127.0.0.1:4723/wd/hub";

    public MobileDriverManager(DriverType driverType, HashMap<String, Object> caps) {
        try {
            this.driver = new AppiumDriver<>(new URL(DEFAULT_LOCAL_URL), setCapsFromHashMap(caps));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        this.driverType = driverType;
    }

    public MobileDriverManager(DriverType driverType, HashMap<String, Object> caps, AppiumDriverLocalService server) {
        this.driver = new AppiumDriver<>(server, setCapsFromHashMap(caps));
        this.driverType = driverType;
        this.server = server;
    }

    public AppiumDriver<MobileElement> getDriver() {
        return this.driver;
    }

    public DriverType getDriverType() {
        return this.driverType;
    }

    public AppiumDriverLocalService getServer() {
        return this.server;
    }

    public void quitMobileDriver() {
        if (this.driver != null) {
            this.driver.quit();
            this.driver = null;
        }
    }

    public static DesiredCapabilities setCapsFromHashMap(HashMap<String, Object> caps) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        for (String key : caps.keySet()) {
            capabilities.setCapability(key, caps.get(key));
        }
        return capabilities;
    }
}
