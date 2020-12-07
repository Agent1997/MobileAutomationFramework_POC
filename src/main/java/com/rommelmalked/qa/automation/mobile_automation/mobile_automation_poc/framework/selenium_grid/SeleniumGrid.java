package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.selenium_grid;

import java.io.IOException;

/*TODO Work on how to start and close Selenium Grid Server via java code.
    Current Progress: Can start but cannot close it.
    But focus first on running test on parallel since I can still start selenium grid via CLI
*/

public class SeleniumGrid {
    private  boolean isRunning = false;
    private  final String SELENIUM_GRID_PATH_FROM_CONTENT_ROOT = "selenium-grid/selenium-server-standalone-3.141.5.jar";
    private Runtime runtimeOpenGrid;
    private Runtime runtimeCloseGrid;

    public  boolean startSeleniumGrid(){
        if(!isRunning){
            runtimeOpenGrid = Runtime.getRuntime();
            try {
                String openCmd = "java -jar " + System.getProperty("user.dir") + "/" + SELENIUM_GRID_PATH_FROM_CONTENT_ROOT;
                System.out.println("Executing " + openCmd );
                runtimeOpenGrid.exec(openCmd);
                System.out.println("RUNNING SELENIUM GRID ON DEFAULT PORT 4444");
            } catch (IOException e) {
                e.printStackTrace();
            }
            isRunning = true;
            return true;
        }
        return false;
    }

    public  boolean startSeleniumGrid(String pathFromContentRoot){
        if(!isRunning){
            runtimeOpenGrid = Runtime.getRuntime();
            try {
                runtimeOpenGrid.exec("java -jar " + System.getProperty("user.dir") + "/" + pathFromContentRoot);
                System.out.println("RUNNING SELENIUM GRID ON DEFAULT PORT 4444");
            } catch (IOException e) {
                e.printStackTrace();
            }
            isRunning = true;
            return true;
        }
        return false;
    }

    public  boolean isRunning(){
        return isRunning;
    }

    public  boolean stopSeleniumGrid(){
        if(isRunning){
            try {
                runtimeOpenGrid.exit(-1);
                String killCmd = "kill -9 $(lsof -ti tcp:4444)";
                runtimeCloseGrid = Runtime.getRuntime();
                runtimeCloseGrid.exec(killCmd);
                System.out.println("Executing " + killCmd);
                System.out.println("CLOSING TCP: 4444");
            } catch (IOException e) {
                e.printStackTrace();
            }
            runtimeCloseGrid.exit(-1);
            isRunning = false;
            return true;
        }
        return false;
    }


}
