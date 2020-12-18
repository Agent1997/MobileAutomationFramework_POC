package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.actions.helpers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

//Refs: https://www.selenium.dev/documentation/en/webdriver/waits/
public class Waits {
    private final AppiumDriver driver;
    private final WebDriverWait wait;

    public Waits(AppiumDriver driver, int waitDurationInSeconds) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver,waitDurationInSeconds);
    }

    public WebElement waitVisibiliy(By elementByLocator){
        return wait.
                until(ExpectedConditions.
                        visibilityOfElementLocated(elementByLocator));
    }

    public WebElement waitClickability(By elementByLocator){
        return wait.
                until(ExpectedConditions.
                        elementToBeClickable(elementByLocator));
    }

    public WebElement waitClickability(WebElement element){
        return wait.
                until(ExpectedConditions.
                        elementToBeClickable(element));
    }

    public WebElement waitVisibility(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public boolean waitToBePresent(By byElementLocator){
        boolean res;
        try{
            List<WebElement> elementList = wait.
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
        List<WebElement> elementList = wait.
                until(ExpectedConditions.
                        visibilityOfAllElements(element));
        if(elementList.size() == 0){
            return false;
        }
        return true;
    }


    public boolean isElementPresent(By elementLocator) throws NoSuchElementException {
        List<WebElement> elementList = driver.findElements(elementLocator);
        if(elementList.size() == 0){
            return false;
        }
        return true;

    }

}
