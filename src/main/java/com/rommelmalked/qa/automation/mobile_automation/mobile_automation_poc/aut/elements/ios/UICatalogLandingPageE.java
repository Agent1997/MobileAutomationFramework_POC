package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.aut.elements.ios;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;

@Getter
public class UICatalogLandingPageE {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Alert Views'")
    private MobileElement alertViewsBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Buttons'")
    private MobileElement buttonsBtn;

    @iOSXCUITFindBy(accessibility = "Date Picker")
    private MobileElement datePicker;


}
