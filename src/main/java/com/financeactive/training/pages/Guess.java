package com.financeactive.training.pages;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.PageReset;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: jvedikunnel
 * Date: 24/10/12
 * Time: 15:00
 */
public class Guess {
    private static final Random RDM = new Random(System.nanoTime());

    @Property
    @Persist
    private Integer target;

    @Property
    @Persist(PersistenceConstants.FLASH)
    private String message;

    @OnEvent(EventConstants.ACTIVATE)
    public void onActivate() {
        if (target == null) {
            resetTarget();
        }
    }

    @Log
    @OnEvent(value = EventConstants.ACTION, component = "guessLink")
    public void onGuess(int guess) {
        if (target == guess) {
            message = "Bravo !";
        } else {
            message = "Bof.";
        }
    }

    @PageReset
    @OnEvent("reset")
    public void resetTarget() {
        target = RDM.nextInt(10) + 1;
    }
}