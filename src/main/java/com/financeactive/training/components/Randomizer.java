package com.financeactive.training.components;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: jvedikunnel
 * Date: 25/10/12
 * Time: 10:46
 */
public class Randomizer {

    @Parameter
    @Property
    private String value;

    @OnEvent(EventConstants.ACTION)
    void onAction() {
        value = UUID.randomUUID().toString();
    }
}