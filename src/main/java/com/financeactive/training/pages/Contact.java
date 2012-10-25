package com.financeactive.training.pages;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;


public class Contact {

    @Property
    private int theGrandTotal = 42;

    @InjectComponent
    private Zone zone1;

    @InjectComponent
    private Zone zone2;

    @Inject
    private AjaxResponseRenderer ajaxResponseRenderer;

    @OnEvent(EventConstants.ACTION)
    public void onAction(int theGrandTotal) {
        this.theGrandTotal = theGrandTotal + 1;
        ajaxResponseRenderer.addRender("zone1", zone1);
        ajaxResponseRenderer.addRender("zone2", zone2);
    }
}
