package com.financeactive.training.services;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.func.F;
import org.apache.tapestry5.func.Mapper;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.ioc.internal.util.CollectionFactory;
import org.apache.tapestry5.services.AssetSource;
import org.apache.tapestry5.services.javascript.JavaScriptStack;
import org.apache.tapestry5.services.javascript.StylesheetLink;

import java.util.Collections;
import java.util.List;

public class HighChartsStack implements JavaScriptStack {

    public static final String STACK_ID = "highChartsStack";

    private final boolean productionMode;

    private final List<Asset> javaScriptStack;

    private final List<StylesheetLink> stylesheetStack;

    public HighChartsStack(@Symbol(SymbolConstants.PRODUCTION_MODE) final boolean productionMode,
                           final AssetSource assetSource) {
        super();
        this.productionMode = productionMode;

        final Mapper<String, Asset> pathToAsset = new Mapper<String, Asset>() {

            public Asset map(String path) {
                return assetSource.getExpandedAsset(path);
            }
        };


        stylesheetStack = CollectionFactory.newList();

        if (productionMode) {

            javaScriptStack = F
                    .flow("${jquery.highcharts.core.path}/highcharts.js")
                    .map(pathToAsset).toList();

        } else {

            javaScriptStack = F
                    .flow("${jquery.highcharts.core.path}/highcharts.src.js")
                    .map(pathToAsset).toList();

        }

    }

    public String getInitialization() {
        return productionMode ? null : "Tapestry.DEBUG_ENABLED = true;";
    }

    public List<Asset> getJavaScriptLibraries() {
        return javaScriptStack;
    }

    public List<StylesheetLink> getStylesheets() {
        return stylesheetStack;
    }

    public List<String> getStacks() {
        return Collections.emptyList();
    }
}
