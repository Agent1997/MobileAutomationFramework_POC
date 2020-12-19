package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.BaseTestImpl;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.actions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopeeTest extends BaseTestImpl {

    @Test
    public void test(){
        Actions actions = new Actions(driver);
        actions.swipeLeft();
        actions.swipeLeft();
        actions.swipeLeft();
        actions.swipeRight();
        actions.swipeRight();
        actions.swipeRight();
//        actions.swipeUp();
//        actions.swipeUp();
//        actions.swipeUp();
//        actions.swipeUp();
//        actions.swipeDown();
//        actions.swipeDown();
//        actions.swipeDown();
//        actions.swipeDown();
        Assert.assertTrue(false);
    }

}
