package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.actions.utils;

import io.appium.java_client.MobileElement;

public class Utils {
    public static boolean isNull(MobileElement element){
        if(element == null){
            return true;
        }
        return false;
    }
}
