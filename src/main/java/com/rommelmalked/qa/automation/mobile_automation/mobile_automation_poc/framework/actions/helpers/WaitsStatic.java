package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.actions.helpers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Wrapper class for WebDriverWait and Expected Conditions
 * @author rommelmalqued
 */
public class WaitsStatic {

    /**
     * @param element
     * @param appiumDriver
     * @param waitDurationInSecs
     * @return null if element is not visible; element(same) if visible
     */
    public static MobileElement waitForVisibilityOfElement(AppiumDriver appiumDriver, MobileElement element, int waitDurationInSecs){
        WebDriverWait wait = new WebDriverWait(appiumDriver,waitDurationInSecs);

        try {
            return (MobileElement) wait.until(ExpectedConditions.visibilityOf(element));
        }catch (StaleElementReferenceException | ElementNotVisibleException e){
            return null;
        }
    }

    /**
     * @param locator
     * @param appiumDriver
     * @param waitDurationInSecs
     * @return null if element is not visible; element(same) if visible
     */
    public static MobileElement waitForVisibilityOfElementLocatedBy(AppiumDriver appiumDriver, By locator, int waitDurationInSecs){
        WebDriverWait wait = new WebDriverWait(appiumDriver,waitDurationInSecs);

        try {
            return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch (StaleElementReferenceException | ElementNotVisibleException e){
            return null;
        }
    }

    /**
     * @param element
     * @param appiumDriver
     * @param waitDurationInSecs
     * @return null if element is not clickable; element(same) if clickable
     */
    public static MobileElement waitForElementToBeClickable(AppiumDriver appiumDriver, MobileElement element, int waitDurationInSecs){
        WebDriverWait wait = new WebDriverWait(appiumDriver,waitDurationInSecs);

        try {
            return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (StaleElementReferenceException | ElementNotVisibleException e){
            return null;
        }
    }

    /**
     * @param locator
     * @param appiumDriver
     * @param waitDurationInSecs
     * @return null if element is not clickable; element(same) if clickable
     */
    public static MobileElement waitForElementLocatedByToBeClickable(AppiumDriver appiumDriver, By locator, int waitDurationInSecs){
        WebDriverWait wait = new WebDriverWait(appiumDriver,waitDurationInSecs);

        try {
            return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
        }catch (StaleElementReferenceException | ElementNotVisibleException e){
            return null;
        }
    }

    /**
     * @param element
     * @param appiumDriver
     * @param waitDurationInSecs
     * @return null if element is not interactable; element(same) if interactable
     */
    public static MobileElement waitForElementToBeInteractalbe(AppiumDriver appiumDriver, MobileElement element, int waitDurationInSecs){
        try{
            return waitForElementToBeClickable(appiumDriver,element,waitDurationInSecs);
        }catch (ElementNotInteractableException e){
            return null;
        }
    }

    /**
     * @param locator
     * @param appiumDriver
     * @param waitDurationInSecs
     * @return null if element is not interactable; element(same) if interactable
     */
    public static MobileElement waitForElementToBeInteractalbe(AppiumDriver appiumDriver, By locator, int waitDurationInSecs){
        try{
            return waitForElementLocatedByToBeClickable(appiumDriver,locator,waitDurationInSecs);
        }catch (ElementNotInteractableException e){
            return null;
        }
    }
}
