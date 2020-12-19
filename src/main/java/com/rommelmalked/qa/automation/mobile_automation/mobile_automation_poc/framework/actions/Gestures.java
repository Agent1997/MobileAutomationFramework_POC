package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.actions;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.actions.helpers.Points;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.actions.helpers.SwipeType;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.actions.utils.Utils;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.actions.wait.WaitsStatic;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;

public class Gestures {
    private final AppiumDriver<MobileElement> appiumDriver;
    private final int waitDurationInSecs;

    public Gestures(AppiumDriver<MobileElement> appiumDriver, int waitDurationInSecs) {
        this.appiumDriver = appiumDriver;
        this.waitDurationInSecs = waitDurationInSecs;
    }

    public void tap(MobileElement element) {
        Utils.isNull(WaitsStatic.waitForElementToBeInteractalbe(appiumDriver, element, waitDurationInSecs));

        new TouchAction(appiumDriver)
                .tap(TapOptions.tapOptions().withElement(element(element)))
                .waitAction(waitOptions(Duration.ofMillis(250)))
                .perform();
    }

    public void multipleTap(MobileElement element, int tapCount){
        for(int i = 0; i < tapCount; i++){
            tap(element);
        }
    }

    private Points determineSwipePoint(SwipeType swipeType){
        Dimension dimension = appiumDriver.manage().window().getSize();
        System.out.println(dimension);
        double anchorPercentage = 0.5;
        int x,y,startPoint,endPoint;
        double value1 = 0.1;
        double value2 = 0.9;

       if(swipeType == SwipeType.DOWN){
            x = (int)(dimension.width * anchorPercentage);      //I'm taking the middle of x-axis
            startPoint = (int) (dimension.height * value1);       //I'm taking a point on the top of the screen
            endPoint = (int) (dimension.height * value2);         //I'm taking a point on the bottom of the screen;
            return new Points(x,null,startPoint,endPoint);
       }

        if(swipeType == SwipeType.UP){
            x = (int)(dimension.width * anchorPercentage);     //I'm taking the middle of x-axis
            startPoint = (int) (dimension.height * value2);      //I'm taking a point on the top of the screen
            endPoint = (int) (dimension.height * value1);        //I'm taking a point on the bottom of the screen;
            return new Points(x,null,startPoint,endPoint);
        }

        if(swipeType == SwipeType.LEFT){
            y = (int)(dimension.height * anchorPercentage);     //I'm taking the middle of y-axis
            startPoint = (int) (dimension.width * value2);      //I'm taking a point on the right side of the screen
            endPoint = (int) (dimension.height * value1);        //I'm taking a point on the left side of the screen;
            return new Points(null,y,startPoint,endPoint);
        }

        if(swipeType == SwipeType.RIGHT){
            y = (int)(dimension.height * anchorPercentage);     //I'm taking the middle of y-axis
            startPoint = (int) (dimension.width * value1);      //I'm taking a point on the right side of the screen
            endPoint = (int) (dimension.height * value2);        //I'm taking a point on the left side of the screen;
            return new Points(null,y,startPoint,endPoint);
        }

        return null;
    }
    private void swipe(SwipeType swipeType, Points points){
        if(swipeType == SwipeType.DOWN || swipeType == SwipeType.UP){
            new TouchAction(appiumDriver)
                    .press(point(points.getX(), points.getStartPoint()))
                    .waitAction(waitOptions(Duration.ofMillis(1000)))
                    .moveTo(point(points.getX(),points.getEndPoint()))
                    .release()
                    .perform();
        }

        if(swipeType == SwipeType.LEFT || swipeType == SwipeType.RIGHT){
            new TouchAction(appiumDriver)
                    .press(point(points.getY(), points.getStartPoint()))
                    .waitAction(waitOptions(Duration.ofMillis(1000)))
                    .moveTo(point(points.getY(),points.getEndPoint()))
                    .release()
                    .perform();
        }
    }

    public void swipeUp(){
        Points points = determineSwipePoint(SwipeType.UP);
        swipe(SwipeType.UP,points);
        System.out.println("Points x: " + points.getX());
//        System.out.println("Points y: " + points.getY());
        System.out.println("Points start: " + points.getStartPoint());
        System.out.println("Points end: " + points.getEndPoint());

    }

    public void swipeDown(){
        Points points = determineSwipePoint(SwipeType.DOWN);
        swipe(SwipeType.DOWN,points);
    }

    public void swipeLeft(){
        Points points = determineSwipePoint(SwipeType.LEFT);
        swipe(SwipeType.LEFT,points);
    }

    public void swipeRight(){
        Points points = determineSwipePoint(SwipeType.RIGHT);
        swipe(SwipeType.RIGHT,points);
    }


}
