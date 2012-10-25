package com.financeactive.training.services;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.services.javascript.JavaScriptStack;
import org.apache.tapestry5.services.javascript.StylesheetLink;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jvedikunnel
 * Date: 25/10/12
 * Time: 15:32
 */
public class TrainingStack implements JavaScriptStack {
    @Override
    public List<String> getStacks() {
        return new LinkedList<String>();
    }

    @Override
    public List<Asset> getJavaScriptLibraries() {
        return new LinkedList<Asset>();
    }

    @Override
    public List<StylesheetLink> getStylesheets() {
        return new LinkedList<StylesheetLink>();
    }

    @Override
    public String getInitialization() {
        return "";
    }
}
