package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.activities;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 *For demo only
 */
public class Actions<T> {
    private AppiumDriver driver;
    private T locators;
//    Logger logger = LogManager.getLogger(CallingClass.getCallerClassName(Actions.class));


    public Actions(AppiumDriver driver, Class<T> locators) {
        this.driver = driver;
        try {
            this.locators = locators.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Actions(AppiumDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {

        try {
//            driver.findElement(locator).click();
//            logger.info("Clicking" + locator.toString());
            getElement(locator).click();
        } catch (NoSuchElementException e) {
//            System.out.println("Element locator \""
//                    + locator + "\" declared in "
//                    + CallingClass.getCallerClassName(Actions.class) +
//                    " does not exist in the current DOM");
        }
    }

    protected void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected boolean isPresent(By locator) {
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

    protected T getLocator() {
//        logger.info("Getting locators of " + locators.getClass().getSimpleName());
        return locators;
    }

    protected WebElement getElement(By locator) {
//        logger.info("Getting element with locator: " + locator);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //just added try catch to retry finding in case first attempt to find element failed
        //Original code w/o try catch
        //return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        try {
            return driver.findElement(locator);
        } catch (Exception err) {
            return wait .until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    protected void hoverToElementAndClickOn(By hoverToElementLocator, By clickOnElementLocator) {
        org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions(this.driver);
        action.moveToElement(getElement(hoverToElementLocator)).pause(500).click(getElement(clickOnElementLocator)).perform();
    }

    protected void hoverToElementAndClickOn(WebElement hoverToElementLocator, WebElement clickOnElementLocator) {
        org.openqa.selenium.interactions.Actions action = new org.openqa.selenium.interactions.Actions(this.driver);
        action.moveToElement(hoverToElementLocator).pause(500).click(clickOnElementLocator).perform();
    }

    protected void enterText(By locator, String text) {
//        logger.info("Entering text: " + text);
        getElement(locator).sendKeys(text);
    }

    protected boolean isTextFieldEmpty(By locator) {
        return getElement(locator).getAttribute("value").isEmpty();
    }

    protected void clearTextFieldBeforeEnteringText(By locator, String text) {
        if (!isTextFieldEmpty(locator)) {
            getElement(locator).clear();
        }
        enterText(locator, text);
    }

    protected void selectValueFromDropDownByValue(By selectableDropdownLocator, String value) {
        Select select = new Select(getElement(selectableDropdownLocator));
        select.selectByValue(value);
    }

    protected void selectValueFromDropDownByVisibleText(By selectableDropdownLocator, String text) {
        Select select = new Select(getElement(selectableDropdownLocator));
        select.selectByVisibleText(text);
    }

    protected boolean isAt(String pageTitle, String specialText, By specialTextLoc, By... locators) {
//        System.out.println(driver.getTitle().equalsIgnoreCase(pageTitle));
        if (pageTitle != null) {
            if (!driver.getTitle().equalsIgnoreCase(pageTitle)) {
                return false;
            }
        }

        for (By loc : locators) {
//            System.out.println(loc.toString());
            if (!isPresent(loc)) {
                return false;
            }
        }

//        System.out.println(isPresent(specialTextLoc));
        if (!isPresent(specialTextLoc)) {
            return false;
        }

//        System.out.println(getElement(specialTextLoc).getText().equalsIgnoreCase(specialText));
        if (!getElement(specialTextLoc).getText().equalsIgnoreCase(specialText)) {
            return false;
        }
        return true;
    }
}
