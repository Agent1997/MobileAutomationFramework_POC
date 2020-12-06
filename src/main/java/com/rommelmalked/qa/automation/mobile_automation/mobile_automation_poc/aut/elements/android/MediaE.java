package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.aut.elements.android;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;

@Getter
public class MediaE {
    @AndroidFindBy(xpath = "@AndroidFindBy(xpath = //android.widget.ImageButton[@content-desc='Navigate up'])")
    private AndroidElement backBtn;


}
