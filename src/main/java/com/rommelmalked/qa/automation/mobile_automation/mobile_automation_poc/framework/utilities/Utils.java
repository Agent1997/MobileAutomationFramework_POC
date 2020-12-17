package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.utilities;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.BaseTestImpl;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * Contains all utilities and helper functions
 *
 * @author Agent1997
 */
public class Utils {

    /**
     * Look for port using ServerSocket
     * Once port is found, socket is closed.
     *
     * @return int: port available for use
     */
    public static int getAvailablePort() {
        int port = 0;

        try {
            ServerSocket serverSocket = new ServerSocket(0);
            port = serverSocket.getLocalPort();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return port;
    }

    public static String getProjectDirectory() {
        return System.getProperty("user.dir") + "/";
    }

    public static String generateFileName(String fileName) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_mm_yyyy_mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return "/" + fileName + "_" + dtf.format(now);
    }

    public static DesiredCapabilities setCapsFromHashMap(HashMap<String, Object> caps) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        for (String key : caps.keySet()) {
            capabilities.setCapability(key, caps.get(key));
        }
        return capabilities;
    }

    public static String getTestNGTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    private static String getBase64ScreenShot(AppiumDriver<MobileElement> mobileDriver) {
        return "data:image/png;base64," + ((TakesScreenshot) mobileDriver).
                getScreenshotAs(OutputType.BASE64);
    }

    public static String getThrownAssertionError(ITestResult iTestResult) {
        return ExceptionUtils.getMessage(ExceptionUtils.getRootCause(iTestResult.getThrowable()));
    }

    public static Media getBase64ScreenShotMedia(ITestResult iTestResult) {
        //Get driver from BaseTest and assign to local driver variable.
        Object testClass = iTestResult.getInstance();
        AppiumDriver<MobileElement> mobileDriver = ((BaseTestImpl) testClass).getDriver();

        return MediaEntityBuilder.createScreenCaptureFromBase64String(Utils.getBase64ScreenShot(mobileDriver)).build();
    }

    public static void getAndSaveScreenShot(ITestResult iTestResult, String screenShotFolderLoc, String screenShotName) {
        String folderLocation = getProjectDirectory() + screenShotFolderLoc;
        File folderLoc = new File(folderLocation);
        makeDirIfItDoNotExist(folderLoc);

        String destination = folderLocation + generateFileName(screenShotName) + ".png";
        File finalDestination = new File(destination);

        Object testClass = iTestResult.getInstance();
        AppiumDriver<MobileElement> mobileDriver = ((BaseTestImpl) testClass).getDriver();
        try {
            FileUtils.copyFile(getScreenshotFile(mobileDriver), finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static File getScreenshotFile(AppiumDriver<MobileElement> driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }

    public static boolean makeDirIfItDoNotExist(File directory) {
        if (!directory.exists()) {
            directory.mkdir();
            return true;
        }
        return false;
    }


}
