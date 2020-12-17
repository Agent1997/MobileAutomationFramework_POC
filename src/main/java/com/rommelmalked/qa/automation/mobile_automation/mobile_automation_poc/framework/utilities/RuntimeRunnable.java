package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.utilities;

import java.io.IOException;



public class RuntimeRunnable implements Runnable{

    private String command;

    public RuntimeRunnable(String command){
        this.command = command;
    }

    @Override
    public void run() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(this.command);
        } catch (IOException e) {
            e.printStackTrace();
        }
        runtime.exit(0);
    }
}
