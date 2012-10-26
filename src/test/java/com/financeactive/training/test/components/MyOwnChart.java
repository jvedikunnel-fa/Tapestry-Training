package com.financeactive.training.test.components;

import com.financeactive.training.components.AbstractHighCharts;
import org.apache.tapestry5.json.JSONObject;

public class MyOwnChart extends AbstractHighCharts {

    public JSONObject getComponentOptions() {

        JSONObject opt = new JSONObject();
        opt.put("text", "Test Override");
        opt.put("x", -20);

        JSONObject high = new JSONObject();
        high.put("subtitle", opt);
        high.put("chart", new JSONObject("renderTo", getClientId()));
        return high;

    }
}
