package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.pageObjects;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.BasePageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 *Good reference for implementing page factory on page objects
 *https://www.toolsqa.com/selenium-webdriver/page-object-pattern-model-page-factory/#:~:text=By%20using%20the%20Page%20Object,create%20tests%20with%20less%20keystroke
 */

/*
TODO: Find a way to get the locator used by the FindBy Annotations.
 ref: https://xbuba.com/questions/41883224  These is already working on Test.java file.
 Just make it cleaner.
 */

public class SamplePom extends BasePageObject {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Alert Views']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Media']")
    private MobileElement sampleBtn;

    public SamplePom(AppiumDriver<MobileElement> driver){
        super(driver);
    }


    public void clickButton() {
        actions.click(sampleBtn);
    }



}
