package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver;

import java.util.HashMap;

/**
 *For demo only
 */
public class MobileCapabilities {
    public static HashMap<String,Object> getAndroidEmulatorCaps(){
        HashMap<String,Object> caps = new HashMap<>();
        String appPath = System.getProperty("user.dir") + "/sample_apps/ApiDemos-debug.apk";
//        caps.put("avd","Pixel_2_API_28");
        caps.put("platformName","Android");
        caps.put("automationName","UiAutomator2");
        caps.put("app",appPath);
        return caps;
    }

    public static HashMap<String,Object> getIOSSimulatorCaps(){
        HashMap<String,Object> caps = new HashMap<>();
        String appPath = System.getProperty("user.dir") + "/sample_apps/UIKitCatalog.app";
        caps.put("platformName","iOS");
        caps.put("automationName","XCUITest");
        caps.put("app",appPath);
        caps.put("noReset",true);
        caps.put("deviceName","iPhone Xr");
        caps.put("platfromVersion","13.5");
        return caps;
    }

}
