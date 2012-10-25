package com.financeactive.training.mixins;

import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectContainer;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 * Created with IntelliJ IDEA.
 * User: jvedikunnel
 * Date: 25/10/12
 * Time: 16:58
 */
@Import(library = "simplealert.js")
public class SimpleAlert {

    @InjectContainer
    private ClientElement container;

    @Inject
    private JavaScriptSupport javaScriptSupport;

    @Parameter
    private String message;

    @AfterRender
    void installJS() {
        JSONObject spec = new JSONObject().put("elementId", container.getClientId()).put("message", message);
        javaScriptSupport.addInitializerCall("installSimpleAlert", spec);
    }
}