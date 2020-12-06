package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.aut.elements.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;

@Getter
public class AlertViewsE {
    @iOSXCUITFindBy(accessibility = "Okay / Cancel")
    private MobileElement okayCancelBtn;

}
