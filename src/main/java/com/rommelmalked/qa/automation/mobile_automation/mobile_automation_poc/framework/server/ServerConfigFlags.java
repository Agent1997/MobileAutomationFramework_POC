package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.server;

import io.appium.java_client.service.local.flags.ServerArgument;

public enum ServerConfigFlags implements ServerArgument {
    NODE_CONFIG("--nodeconfig");

    private final String arg;

    ServerConfigFlags(String arg) {
        this.arg = arg;
    }

    @Override
    public String getArgument() {
        return null;
    }
}
