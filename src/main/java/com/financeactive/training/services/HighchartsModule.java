package com.financeactive.training.services;

import com.financeactive.training.HighChartsSymbolConstants;
import org.apache.tapestry5.ioc.Configuration;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.services.LibraryMapping;
import org.apache.tapestry5.services.javascript.JavaScriptStack;

public class HighchartsModule {

    public static void contributeJavaScriptStackSource(
            MappedConfiguration<String, JavaScriptStack> configuration) {
        configuration.addInstance(HighChartsStack.STACK_ID,
                                  HighChartsStack.class);
    }

    public static void contributeComponentClassResolver(
            Configuration<LibraryMapping> configuration) {
        configuration.add(new LibraryMapping("jquery-highcharts",
                                             "com.financeactive.training"));
    }

    public static void contributeClasspathAssetAliasManager(
            MappedConfiguration<String, String> configuration) {
        configuration.add("tap-jquery-highcharts", "com/financeactive/training");
    }

    public static void contributeFactoryDefaults(MappedConfiguration<String, String> configuration) {

        configuration.add(HighChartsSymbolConstants.JQUERY_HIGHCHARTS_CORE_PATH, "classpath:com/financeactive/training/asset");

    }
}
