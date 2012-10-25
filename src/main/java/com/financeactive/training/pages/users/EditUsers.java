package com.financeactive.training.pages.users;

import com.financeactive.training.entities.User;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

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

    @Inject
    Session hbSession;

    @OnEvent(value = EventConstants.ACTION, component = "update")
    public void onEdit(User user) {
        hbSession.update(user);
    }
}