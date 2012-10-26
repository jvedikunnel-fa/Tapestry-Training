package com.financeactive.training.pages;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.InitializationPriority;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

import java.util.Date;

/**
 * Start page of application training.
 */
@RequiresAuthentication
public class Index {
    @Property
    @Inject
    @Symbol(SymbolConstants.TAPESTRY_VERSION)
    private String tapestryVersion;

    @InjectComponent
    private Zone zone;

    @Persist
    @Property
    private int clickCount;

    @Inject
    private AlertManager alertManager;

    public Date getCurrentTime() {
        return new Date();
    }

    void onActionFromIncrement() {
        alertManager.info("Increment clicked");

        clickCount++;
    }

    Object onActionFromIncrementAjax() {
        clickCount++;

        alertManager.info("Increment (via Ajax) clicked");

        return zone;
    }

    @Inject
    private JavaScriptSupport javascript;

    public JSONObject getOptions() {
        JSONObject opt = new JSONObject();
        opt.put("text", "Source: WorldClimate.com");
        opt.put("x", -20);

        JSONObject high = new JSONObject();
        high.put("subtitle", opt);

        return high;
    }

    @AfterRender
    public void afterRender() {
        javascript.addInitializerCall(InitializationPriority.EARLY, "basicComponent", new JSONObject());
//        javascript.addInitializerCall("documentation", new JSONObject());
    }
}
