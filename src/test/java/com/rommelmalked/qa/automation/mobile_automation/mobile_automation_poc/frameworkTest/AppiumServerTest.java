package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.frameworkTest;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.server.AppiumServer;

public class AppiumServerTest {

    public static void main(String[] args) {
        AppiumServer server = new AppiumServer();
        server.startServer();
        server.stopServer();

    }
}
