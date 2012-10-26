package com.financeactive.training.test.services;

import com.financeactive.training.services.HighchartsModule;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.annotations.SubModule;

@SubModule(HighchartsModule.class)
public class AppModule {

    public static void contributeApplicationDefaults(MappedConfiguration<String, String> configuration) {

        configuration.add(SymbolConstants.PRODUCTION_MODE, "true");
        configuration.add("demo-src-dir", "D:\\Documents\\a503018\\Documents\\WEBPLATFORM_DOCUMENTATION\\TAPESTRY5-jQUERY\\tapestry5-highcharts\\src\\test\\");
    }

}
