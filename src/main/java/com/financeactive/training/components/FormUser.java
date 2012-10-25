package com.financeactive.training.components;

import com.financeactive.training.entities.User;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

/**
 * Created with IntelliJ IDEA.
 * User: jvedikunnel
 * Date: 25/10/12
 * Time: 11:57
 */
public class FormUser {

    @Parameter
    @Property
    private User user;
}