package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.aut.elements.android;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;

@Getter
public class APIDemosLandingPageE {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='API Demos']")
    private AndroidElement apiDemosBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Support v4 Demos']")
    private AndroidElement supportV4DemosBtn;

}
