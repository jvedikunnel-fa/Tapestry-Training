package com.financeactive.training.pages;

import org.apache.tapestry5.dom.Document;
import org.apache.tapestry5.test.PageTester;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: jvedikunnel
 * Date: 24/10/12
 * Time: 16:23
 */
public class GuessTest {
    private PageTester pageTester;

    @BeforeClass
    public void setupPageTester() {
        pageTester = new PageTester("com.financeactive.training", "app");
    }

    @Test
    public void very_hilo_game() {
        Document doc = pageTester.renderPage("Guess");

    }
}
