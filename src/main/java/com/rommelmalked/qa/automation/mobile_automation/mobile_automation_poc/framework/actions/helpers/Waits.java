package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.actions.helpers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

//Refs: https://www.selenium.dev/documentation/en/webdriver/waits/
public class Waits {
    private final AppiumDriver<WebElement> mobileDriver;
    private final WebDriverWait wait;

    public Waits(AppiumDriver mobileDriver, int waitDurationInSeconds) {
        this.mobileDriver = mobileDriver;
        this.wait = new WebDriverWait(this.mobileDriver,waitDurationInSeconds);
    }

    public WebElement waitVisibility(By elementByLocator){
        return this.wait.
                until(ExpectedConditions.
                        visibilityOfElementLocated(elementByLocator));
    }

    public WebElement waitVisibility(MobileElement element){
        return this.wait.
                until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitClickability(By elementByLocator){
        return this.wait.
                until(ExpectedConditions.
                        elementToBeClickable(elementByLocator));
    }

    public WebElement waitClickability(WebElement element){
        return this.wait.
                until(ExpectedConditions.
                        elementToBeClickable(element));
    }

    public boolean waitToBePresent(By byElementLocator){
        boolean res;
        try{
            List<WebElement> elementList = this.wait.
                    until(ExpectedConditions.
                            presenceOfAllElementsLocatedBy(byElementLocator));
            if(elementList.size() == 0){
                res = false;
            }
            res = true;
        }catch (Exception e){
            res = false;
        }
        return res;
    }

    public boolean waitToBePresent(WebElement element){
        List<WebElement> elementList = this.wait.
                until(ExpectedConditions.
                        visibilityOfAllElements(element));
        if(elementList.size() == 0){
            return false;
        }
        return true;
    }


    public boolean isElementPresent(By elementLocator){
        List<WebElement> elementList = this.mobileDriver.findElements(elementLocator);
        if(elementList.size() == 0){
            return false;
        }
        return true;
    }

}
