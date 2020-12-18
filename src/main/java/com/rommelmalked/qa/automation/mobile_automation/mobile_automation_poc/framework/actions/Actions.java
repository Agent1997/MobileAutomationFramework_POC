package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 *TODO work on handling all commonly used actions
 */
public class Actions {
    private AppiumDriver driver;


    public Actions(AppiumDriver driver) {
        this.driver = driver;
    }


    public void click(By locator) {

        try {
            getElement(locator).click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void click(MobileElement element) {
        try {
            element.click();
        } catch (Exception e) {
            System.out.println(e);
        }
    }



    public boolean isPresent(By locator) {
        List<WebElement> el;
        try {
            el = driver.findElements(locator);
        } catch (Exception e) {
            return false;
        }

        if (el.size() > 0) {
            return true;
        }

        return false;
    }


    public WebElement getElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            return driver.findElement(locator);
        } catch (Exception err) {
            return wait .until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public void hoverToElementAndClickOn(By hoverToElementLocator, By clickOnElementLocator) {
        org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions(this.driver);
        action.moveToElement(getElement(hoverToElementLocator)).pause(500).click(getElement(clickOnElementLocator)).perform();
    }

    public void hoverToElementAndClickOn(WebElement hoverToElementLocator, WebElement clickOnElementLocator) {
        org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions(this.driver);
        action.moveToElement(hoverToElementLocator).pause(500).click(clickOnElementLocator).perform();
    }

    public void enterText(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    public boolean isTextFieldEmpty(By locator) {
        return getElement(locator).getAttribute("value").isEmpty();
    }

    public void clearTextFieldBeforeEnteringText(By locator, String text) {
        if (!isTextFieldEmpty(locator)) {
            getElement(locator).clear();
        }
        enterText(locator, text);
    }

    public void selectValueFromDropDownByValue(By selectableDropdownLocator, String value) {
        Select select = new Select(getElement(selectableDropdownLocator));
        select.selectByValue(value);
    }

    public void selectValueFromDropDownByVisibleText(By selectableDropdownLocator, String text) {
        Select select = new Select(getElement(selectableDropdownLocator));
        select.selectByVisibleText(text);
    }

    public boolean isAt(String pageTitle, String specialText, By specialTextLoc, By... locators) {
        if (pageTitle != null) {
            if (!driver.getTitle().equalsIgnoreCase(pageTitle)) {
                return false;
            }
        }

        for (By loc : locators) {
            if (!isPresent(loc)) {
                return false;
            }
        }

        if (!isPresent(specialTextLoc)) {
            return false;
        }

        if (!getElement(specialTextLoc).getText().equalsIgnoreCase(specialText)) {
            return false;
        }
        return true;
    }
}
