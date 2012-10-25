package com.financeactive.training.pages.users;

import com.financeactive.training.entities.User;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

/**
 * Created with IntelliJ IDEA.
 * User: jvedikunnel
 * Date: 24/10/12
 * Time: 17:35
 */
public class CreateUsers {

    @Property
    private User user;

    @Inject
    private Session hbSession;

    @OnEvent(EventConstants.SUCCESS)
    @CommitAfter
    private Class onSuccess() {
        hbSession.save(user);
        return IndexUsers.class;
    }
}