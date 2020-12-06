package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.aut.elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class sample {
    //This is for demo only

    @iOSXCUITFindBy(accessibility = "Okay / Cancel")
    @AndroidFindBy(accessibility = "Navigate up")
    private MobileElement backBtn;
}
