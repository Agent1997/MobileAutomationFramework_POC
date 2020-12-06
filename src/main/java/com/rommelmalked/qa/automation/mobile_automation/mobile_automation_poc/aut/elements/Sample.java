package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.aut.elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;

@Getter
public class Sample {
    //This is for demo only

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Alert Views'")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Media']")
    private MobileElement sampleBtn;
}
