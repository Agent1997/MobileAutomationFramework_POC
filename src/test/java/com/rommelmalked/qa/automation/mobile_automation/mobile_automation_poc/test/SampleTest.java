package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.test;

import com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.BaseTestImpl;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 *For demo only
 */

public class SampleTest extends BaseTestImpl {
    @Test
    public void sampleTestRun(){
        samplePom.clickButton();
        assertTrue(false);
    }

    @Test
    public void sampleTestRun1(){
        assertTrue(true);
    }

}
