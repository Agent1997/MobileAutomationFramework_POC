package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.selenium_grid;

import org.openqa.grid.internal.utils.configuration.GridHubConfiguration;
import org.openqa.grid.web.Hub;


public class SeleniumGridHub {
    private GridHubConfiguration gridHubConfiguration;
    private Hub hub;

    public SeleniumGridHub() {
//      This will instantiate gridHubConfiguration to default config
        gridHubConfiguration = new GridHubConfiguration();
        gridHubConfiguration.newSessionWaitTimeout = 30000000;
        gridHubConfiguration.host = "localhost";
        gridHubConfiguration.port = 4444;
    }

    public void start() {
        if (hub == null) {
            hub = new Hub(gridHubConfiguration);
            hub.start();
        }
    }

    public void stop(){
        if(hub != null){
            hub.stop();
        }
    }

/*TODO Work on how to start and close Selenium Grid Server via java code.
    Current Progress: Can start but cannot close it.
    But focus first on running test on parallel since I can still start selenium grid via CLI.
    Below code is to start Selenium Grid server via CL. Can start but having issue on closing. This is not a priority since above code is working
*/
//    private  boolean isRunning = false;
//    private  final String SELENIUM_GRID_PATH_FROM_CONTENT_ROOT = "selenium-grid/selenium-server-standalone-3.141.5.jar";
//    private Runtime runtimeOpenGrid;
//    private Runtime runtimeCloseGrid;
//
//    public  boolean startSeleniumGrid(){
//        if(!isRunning){
//            runtimeOpenGrid = Runtime.getRuntime();
//            try {
//                String openCmd = "java -jar " + System.getProperty("user.dir") + "/" + SELENIUM_GRID_PATH_FROM_CONTENT_ROOT + " -role hub";
//                System.out.println("Executing " + openCmd );
//                runtimeOpenGrid.exec(openCmd);
//                System.out.println("RUNNING SELENIUM GRID ON DEFAULT PORT 4444");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            isRunning = true;
//            return true;
//        }
//        return false;
//    }
//
//    public  boolean startSeleniumGrid(String pathFromContentRoot){
//        if(!isRunning){
//            runtimeOpenGrid = Runtime.getRuntime();
//            try {
//                runtimeOpenGrid.exec("java -jar " + System.getProperty("user.dir") + "/" + pathFromContentRoot  + " -role hub") ;
//                System.out.println("RUNNING SELENIUM GRID ON DEFAULT PORT 4444");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            isRunning = true;
//            return true;
//        }
//        return false;
//    }
//
//    public  boolean isRunning(){
//        return isRunning;
//    }
//
//    public  boolean stopSeleniumGrid(){
//        if(isRunning){
//            try {
//                runtimeOpenGrid.exit(-1);
//                String killCmd = "kill -9 $(lsof -ti tcp:4444)";
//                runtimeCloseGrid = Runtime.getRuntime();
//                runtimeCloseGrid.exec(killCmd);
//                System.out.println("Executing " + killCmd);
//                System.out.println("CLOSING TCP: 4444");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            runtimeCloseGrid.exit(-1);
//            isRunning = false;
//            return true;
//        }
//        return false;
//    }


}
