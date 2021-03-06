package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.server;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.utilities.Utils;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


/**
 * This is to simplify initializing appium server
 * by creating easily understandable functions.
 * <p>
 * Note: If you want to disable logging on console and log to a file instead.
 * Make sure to call redirectLogTo before starting the server.
 * <p>
 * There just one possible issue but I don't see any negative use case as of now. T
 * Log files will be separate per AppiumServer object.
 * <p>
 * Appium server will run on local host
 * <p>
 * NOTE: Seems that there is an issue with AppiumDriverLocalService start and stop methods,
 * but code still works fine (Dec 13, 2020)
 *
 * @author Agent1997
 */

/*
TODO Check error encountered here. Following a failed test execution, appium port is not closed.
 When Before Class failed. It seems that it is causing the issue
 [Appium] Non-default server args:
 [Appium]   port: 4444
 [HTTP] Could not start REST http interface listener. The requested port may already be in use. Please make sure there is no other instance of this server running already.
 Fatal Error: listen EADDRINUSE: address already in use 0.0.0.0:4444
    at Server.setupListenHandle [as _listen2] (net.js:1318:16)
    at listenInCluster (net.js:1366:12)
    at doListen (net.js:1503:7)
    at processTicksAndRejections (internal/process/task_queues.js:81:21)
 */

public class AppiumServer {
    private final AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
    private final AppiumDriverLocalService server;
    private final int port;
    private final static String appiumLogsLoc = "appiumLogs";

    /***
     *This default constructor will use the port randomly generated by Utils.getAvailablePort
     */

    public AppiumServer() {
        this.port = Utils.getAvailablePort();
        this.serviceBuilder.usingPort(port);
        this.server = AppiumDriverLocalService.buildService(serviceBuilder);
        this.startServer();
    }

    public AppiumServer(int port) {
        this.port = port;
        this.serviceBuilder.usingPort(port);
        this.server = AppiumDriverLocalService.buildService(serviceBuilder);
        this.startServer();
    }

    public AppiumServer startServer() {
        this.server.start();
        return this;
    }

    public void stopServer() {
        this.server.stop();
    }

    public boolean isRunning() {
        return this.server.isRunning();
    }

    public AppiumServiceBuilder getServiceBuilder() {
        return this.serviceBuilder;
    }

    public AppiumDriverLocalService getServer() {
        return this.server;
    }

    public int getPort() {
        return this.port;
    }

    private void redirectLogTo(String folderName, String fileName, AppiumDriverLocalService server) {
        server.clearOutPutStreams();
        File directory = new File(Utils.getProjectDirectory() + folderName);

//        if (!directory.exists()) {
//            directory.mkdir();
//        }
//        Commenting out above code, change by below code
        Utils.makeDirIfItDoNotExist(directory);

        try {
            server.addOutPutStream(new FileOutputStream(Utils.getProjectDirectory() + folderName + Utils.generateFileName(fileName)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public AppiumServer redirectLogTo(String filename) {
        redirectLogTo(appiumLogsLoc, filename, this.server);
        return this;
    }
}
