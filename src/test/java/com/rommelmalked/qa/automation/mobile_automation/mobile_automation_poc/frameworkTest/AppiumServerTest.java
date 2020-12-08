package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.frameworkTest;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.server.AppiumServer;

import java.io.IOException;
import java.net.ServerSocket;

public class AppiumServerTest {

    public static void main(String[] args) {
        AppiumServer server = new AppiumServer();
        ServerSocket ss = null;
        try {
           ss = new ServerSocket(0);
            System.out.println(ss.getLocalPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(ss.getLocalPort());
        server.startServer();
        server.stopServer();

    }
}
