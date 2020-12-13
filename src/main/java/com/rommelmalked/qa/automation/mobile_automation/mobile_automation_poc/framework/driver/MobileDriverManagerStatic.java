package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.utilities.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class MobileDriverManagerStatic {
    public static AppiumDriver<MobileElement> getMobileDriver(HashMap<String, Object> caps) {
        AppiumDriver<MobileElement> driver = null;

        try {
            driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), Utils.setCapsFromHashMap(caps));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }

    public static AppiumDriver<MobileElement> getMobileDriver(HashMap<String, Object> caps, AppiumDriverLocalService server) {
        return new AppiumDriver<>(server, Utils.setCapsFromHashMap(caps));
    }

    public static AppiumDriver<MobileElement> getMobileDriver(HashMap<String, Object> caps, AppiumServiceBuilder serviceBuilder) {
        return new AppiumDriver<>(serviceBuilder, Utils.setCapsFromHashMap(caps));
    }
}
