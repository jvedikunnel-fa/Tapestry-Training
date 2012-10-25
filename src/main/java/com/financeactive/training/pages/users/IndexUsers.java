package com.financeactive.training.pages.users;

import com.financeactive.training.entities.User;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jvedikunnel
 * Date: 24/10/12
 * Time: 17:34
 */
public class IndexUsers {

    @Inject
    Session hbSession;

    public List<User> getUsers() {
        return hbSession.createCriteria(User.class).list();
    }

    @OnEvent(value = EventConstants.ACTION, component = "delete")
    @CommitAfter
    void onDelete(User user) {
        hbSession.delete(user);
    }
}