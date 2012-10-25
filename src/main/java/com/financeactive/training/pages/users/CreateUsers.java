package com.financeactive.training.pages.users;

import com.financeactive.training.entities.User;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;

/**
 * Created with IntelliJ IDEA.
 * User: jvedikunnel
 * Date: 24/10/12
 * Time: 17:35
 */
public class CreateUsers {

    @Property
    private User user;

    @OnEvent(EventConstants.SUCCESS)
    private Class onSuccess() {
        System.out.println("user : " + user);
        return IndexUsers.class;
    }
}