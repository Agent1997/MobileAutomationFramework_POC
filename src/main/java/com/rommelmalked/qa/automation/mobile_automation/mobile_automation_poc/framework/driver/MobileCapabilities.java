package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver;

import java.util.HashMap;

/**
 *For demo only
 */
public class MobileCapabilities {
    public static HashMap<String,Object> getAndroidEmulatorCaps(){
        HashMap<String,Object> caps = new HashMap<>();
        String appPath = System.getProperty("user.dir") + "/sampleApps/ApiDemos-debug.apk";
//        caps.put("avd","Pixel_2_API_28"); //This can be uncommented to automatically open your emulator, though I'm encountering issues on rerunning scripts
        caps.put("platformName","Android");
        caps.put("automationName","UiAutomator2");
        caps.put("app",appPath);
        return caps;
    }

    public static HashMap<String,Object> getIOSSimulatorCaps(){
        HashMap<String,Object> caps = new HashMap<>();
        String appPath = System.getProperty("user.dir") + "/sampleApps/UIKitCatalog.app";
        caps.put("platformName","iOS");
        caps.put("automationName","XCUITest");
        caps.put("app",appPath);
        caps.put("noReset",true);
        caps.put("deviceName","iPhone Xr"); // Change the device name depending on what simulators is available to you
        caps.put("platfromVersion","13.5"); // Update platformVersion Accordingly
        return caps;
    }

}
