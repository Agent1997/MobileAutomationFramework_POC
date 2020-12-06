package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.aut.elements.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;

@Getter
public class APIDemosE {
    @AndroidFindBy(accessibility = "Navigate up")
    private MobileElement backBtn;

//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='android:id/text1']")
//    private MobileElement mediaBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Media']")
    private MobileElement mediaBtn;

}
