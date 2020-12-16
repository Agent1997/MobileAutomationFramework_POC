package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.utilities;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;

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
    public static int getAvailablePort(){
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

    public static String getProjectDirectory(){
        return System.getProperty("user.dir") + "/";
    }

    public static String generateFileName(String fileName){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_mm_yyyy_mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return "/" + fileName +"_" + dtf.format(now);
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
}
