package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.actions.Actions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePageObject {
    protected AppiumDriver<MobileElement> mobileDriver;
    protected Actions actions;

    public BasePageObject(AppiumDriver<MobileElement> mobileDriver){
        this.mobileDriver = mobileDriver;
        this.actions = new Actions(mobileDriver);
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver),this);
    }

}
