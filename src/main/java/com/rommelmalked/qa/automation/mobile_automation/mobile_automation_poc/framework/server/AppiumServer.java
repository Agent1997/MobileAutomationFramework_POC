package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.server;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServer {
    private AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
    private AppiumDriverLocalService server;

    public AppiumServer(){
        serviceBuilder.usingAnyFreePort();
        server = AppiumDriverLocalService.buildService(serviceBuilder);
    }

    public void startServer(){
        server.start();
    }
    public void stopServer(){
        server.stop();
    }
    public AppiumServiceBuilder getServiceBuilder(){
        return serviceBuilder;
    }
    public AppiumDriverLocalService getServer(){return server;}
}
