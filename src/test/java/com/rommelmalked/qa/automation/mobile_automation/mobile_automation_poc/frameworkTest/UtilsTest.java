package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.frameworkTest;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.utilities.Utils;
import org.testng.annotations.Test;

public class UtilsTest {
    @Test(enabled = false)
    public void getAvailablePortTest(){
        System.out.println(Utils.getAvailablePort());
    }

    @Test(enabled = false)
    public void getProjectDirectoryTest(){
        System.out.println(Utils.getProjectDirectory());
    }

    @Test
    public void generateFileNameTest(){
        System.out.println(Utils.generateFileName("Test"));
    }
}
