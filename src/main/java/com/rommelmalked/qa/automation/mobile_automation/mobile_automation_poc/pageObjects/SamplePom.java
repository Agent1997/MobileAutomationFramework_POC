package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.pageObjects;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.activities.Actions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *For demo only
 */

/*
TODO: Find a way to get the locator used by the FindBy Annotations.
 ref: https://xbuba.com/questions/41883224  These is already working on Test.java file.
 Just make it cleaner.
 */

public class SamplePom extends Actions{

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Alert Views']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Media']")
    private MobileElement sampleBtn;

    public SamplePom(AppiumDriver driver){
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void clickButton() {
        click(sampleBtn);
    }

}
