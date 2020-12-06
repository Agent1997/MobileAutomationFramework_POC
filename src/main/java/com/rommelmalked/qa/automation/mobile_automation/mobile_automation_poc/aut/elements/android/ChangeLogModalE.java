package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.aut.elements.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;

@Getter
public class ChangeLogModalE {
    @AndroidFindBy(id = "com.touchboarder.android.api.demos:id/buttonDefaultPositive")
    private MobileElement okBtn;
}
