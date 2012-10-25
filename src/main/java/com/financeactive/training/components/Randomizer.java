package com.financeactive.training.components;

import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: jvedikunnel
 * Date: 25/10/12
 * Time: 10:46
 */
@Import(library = "randomizer.js")
public class Randomizer {

    @InjectComponent
    private ClientElement theLink;

    @Inject
    private JavaScriptSupport javaScriptSupport;

    @Parameter
    @Property
    private String value;

    @Parameter
    private String message;

    @OnEvent(EventConstants.ACTION)
    void onAction() {
        value = UUID.randomUUID().toString();
    }

    @AfterRender
    void installJS() {
        JSONObject spec = new JSONObject().put("elementId", theLink.getClientId()).put("message", message);
        javaScriptSupport.addInitializerCall("installSimpleAlert", spec);
    }
}