package com.financeactive.training.components;

import com.financeactive.training.entities.User;
import com.financeactive.training.pages.users.IndexUsers;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: jvedikunnel
 * Date: 25/10/12
 * Time: 11:57
 */
public class FormUser {

    @Property
    @Parameter(required = true, defaultPrefix = BindingConstants.PROP)
    private User user;

    @Inject
    private Session hbSession;

    @InjectComponent
    private Form formUtilisateur;

    @OnEvent(EventConstants.SUCCESS)
    @CommitAfter
    private Class onSuccess() {
        hbSession.saveOrUpdate(user);
        return IndexUsers.class;
    }

    @OnEvent(value = EventConstants.VALIDATE, component = "formUtilisateur")
    public void onValidateFromEmail() {
        String email = this.user.getEmail();
        if (email != null && (!email.contains("@") || !email.contains("."))) {
            formUtilisateur.recordError("Mail malformé (doit contenir @ et .)");
        }
    }

    @OnEvent(EventConstants.PROVIDE_COMPLETIONS)
    public List<String> onProvideCompletions(String debutMot) {
        LinkedList<String> resultats = new LinkedList<String>();
        resultats.add(debutMot + new Random().nextDouble());
        if (new Random().nextInt() % 2 == 1) {
            resultats.add(debutMot + new Random().nextDouble());
        }

        if (new Random().nextInt() % 2 == 1) {
            resultats.add(debutMot + new Random().nextDouble());
        }

        if (new Random().nextInt() % 2 == 1) {
            resultats.add(debutMot + new Random().nextDouble());
        }

        if (new Random().nextInt() % 2 == 1) {
            resultats.add(debutMot + new Random().nextDouble());
        }

        if (new Random().nextInt() % 2 == 1) {
            resultats.add(debutMot + new Random().nextDouble());
        }

        if (new Random().nextInt() % 2 == 1) {
            resultats.add(debutMot + new Random().nextDouble());
        }

        return resultats;
    }
}