package com.financeactive.training.pages.users;

import com.financeactive.training.entities.User;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;

/**
 * Created with IntelliJ IDEA.
 * User: jvedikunnel
 * Date: 25/10/12
 * Time: 11:51
 */
public class EditUsers {

    @PageActivationContext
    @Property
    private User user;
}