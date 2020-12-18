package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.actions;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.actions.helpers.Waits;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class Gestures {
    private final AppiumDriver driver;
    private final Waits waits;

    public Gestures(AppiumDriver driver, int waitDurationInSeconds) {
        this.driver = driver;
        this.waits = new Waits(driver, waitDurationInSeconds);
    }

    //Tap to an element for 250 milliseconds
    public  void tapByElement(MobileElement element) {
        waits.waitToBePresent(element);
        new TouchAction(driver)
                .tap(TapOptions.tapOptions().withElement(element(element)))
                .waitAction(waitOptions(ofMillis(250))).perform();
    }

    public void tapByElementLocator(By elementLocator) {
        waits.waitToBePresent(elementLocator);
        MobileElement element = (MobileElement) driver.findElement(elementLocator);
        tapByElement(element);
    }

    //Tap by coordinates
    public void tapByCoordinates(int x, int y) {
        new TouchAction(driver)
                .tap(point(x, y))
                .waitAction(waitOptions(ofMillis(250))).perform();
    }

    //Tap by point
    public void tapByPoint(Point point) {
        tapByCoordinates(point.x, point.y);
    }

    //Press by element
    public void pressByElement(MobileElement element, long seconds) {
        new TouchAction(driver)
                .press(element(element))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }

    //Press by coordinates
    public void pressByCoordinates(int x, int y, long durationInSeconds) {
        new TouchAction(driver)
                .press(point(x, y))
                .waitAction(waitOptions(ofSeconds(durationInSeconds)))
                .release()
                .perform();
    }

    public void pressByPoint(Point point, long durationInSeconds) {
        pressByCoordinates(point.x, point.y, durationInSeconds);
    }

    /**
     * Horizontal Swipe by percentages
     *
     * @param startPercentage  : used to get the starting X - point. Left to Right
     * @param endPercentage    : used to get the end X - point. Left to Right
     * @param anchorPercentage : used to determine the Y-point. Top to bottom
     */
    public void horizontalSwipeByPercentage(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int y = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);

        new TouchAction(driver)
                .press(point(startPoint, y))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(endPoint, y))
                .release().perform();
    }

    public void horizontalSwipeByPercentage(double startPercentage, double endPercentage, double anchorPercentage, By containerLocator) {
        int locX = driver.findElement(containerLocator).getLocation().x;
        Dimension size = driver.manage().window().getSize();
        int y = (int) (size.height * anchorPercentage);
        int startPoint = locX + (int) (size.width * startPercentage);
        int endPoint = locX + (int) (size.width * endPercentage);

        new TouchAction(driver)
                .press(point(startPoint, y))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(endPoint, y))
                .release().perform();
    }

    /**
     * Vertical Swipe by percentages
     *
     * @param startPercentage  : Used to determine the starting Y - point. Top to bottom.
     * @param endPercentage    : Used to determine the ending Y - Point. Top to bottom.
     * @param anchorPercentage : Used to determine the X - point. Left to right.
     */
    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int x = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);

        new TouchAction(driver)
                .press(point(x, startPoint))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(x, endPoint))
                .release().perform();
    }

    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage, By containerLocator) {
        int locY = driver.findElement(containerLocator).getLocation().y;
        Dimension size = driver.findElement(containerLocator).getSize();
        int x = (int) (size.width * anchorPercentage);
        int startPoint = locY + (int) (size.height * startPercentage);
        int endPoint = locY + (int) (size.height * endPercentage);

        new TouchAction(driver)
                .press(point(x, startPoint))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(x, endPoint))
                .release().perform();
    }

    /**
     * Swipe by elements
     *
     * @param startElement : Pass an element here not a locator
     * @param endElement   : Pass an element here not a locator
     */
    public void swipeByElements(MobileElement startElement, MobileElement endElement) {
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

        new TouchAction(driver)
                .press(point(startX, startY))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(endX, endY))
                .release().perform();
    }

    public void swipeByElements(By startElementLocator, By endElementLocator) {
        WebElement startElement = driver.findElement(startElementLocator);
        WebElement endElement = driver.findElement(endElementLocator);
        int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

        int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

        new TouchAction(driver)
                .press(point(startX, startY))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(endX, endY))
                .release().perform();
    }

    //Multitouch action by using an android element
    public void multiTouchByElement(MobileElement element) {
        TouchAction press = new TouchAction(driver)
                .press(element(element))
                .waitAction(waitOptions(ofSeconds(1)))
                .release();

        new MultiTouchAction(driver)
                .add(press)
                .perform();
    }
}
