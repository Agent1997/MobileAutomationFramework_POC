package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.aut.elements.android;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;

@Getter
public class APIDemosE {
    @AndroidFindBy(accessibility = "Navigate up")
    private AndroidElement backBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='android:id/text1']")
    private AndroidElement mediaBtn;

}
