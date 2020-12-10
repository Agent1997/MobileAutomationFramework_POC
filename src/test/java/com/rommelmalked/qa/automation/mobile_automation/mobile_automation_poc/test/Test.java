package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.test;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver.MobileCapabilities;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.driver.MobileDriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Field;

class Test1 {
//    public static void main(String[] args) {
//        SeleniumGridHub sg = new SeleniumGridHub();
//        sg.start();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        sg.stop();
//    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Alert Views']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Media']")
    private MobileElement sampleBtn;

    public Test1(){
        MobileDriver driver = null;
        try {
             driver = new AppiumDriver(MobileDriverManager.setCapsFromHashMap(MobileCapabilities.getAndroidEmulatorCaps()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        Field field = null;
        try {
            field = this.getClass().getDeclaredField("sampleBtn");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        AndroidFindBy annotation = field.getAnnotation(AndroidFindBy.class);
        System.out.println(annotation.xpath());
        System.out.println(annotation.accessibility());
    }

}

public class Test{
    public static void main(String[] args) {
        Test1 t = new Test1();
    }
}


