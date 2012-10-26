package com.financeactive.training.test;

import com.thoughtworks.selenium.Wait;
import org.apache.tapestry5.test.SeleniumTestCase;
import org.testng.annotations.Test;

public class HighchartsTest extends SeleniumTestCase {

    @Test
    public void testJSFile() {
        open("/BasicComponent");

        new Wait() {

            @Override
            public boolean until() {
                return isElementPresent("//head/script[contains(@src,'highcharts.src.js')]");
            }
        }.wait("The HighCharts JavaScript file is missing.", 5000l);
    }
}
