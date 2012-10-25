package com.financeactive.training.components;

import org.apache.tapestry5.annotations.Component;

/**
 * Created with IntelliJ IDEA.
 * User: jvedikunnel
 * Date: 25/10/12
 * Time: 10:36
 */
public class ValueField {

    @Component(id = "theField", publishParameters = "value")
    private String value;
}