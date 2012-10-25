package com.financeactive.training.pages;

import org.apache.tapestry5.test.SeleniumTestCase;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: jvedikunnel
 * Date: 24/10/12
 * Time: 15:38
 */
public class GuessIntegrationTest extends SeleniumTestCase {

    @Test
    public void veryfy_hilo_game() {
        open("/guess");
        clickAndWait("link=Guess 1");
    }
}
