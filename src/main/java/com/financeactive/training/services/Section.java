package com.financeactive.training.services;

import org.apache.tapestry5.services.ComponentClassResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jvedikunnel
 * Date: 26/10/12
 * Time: 10:05
 */
public class Section {

    private ComponentClassResolver resolver;

    private List<String> pages = new ArrayList<String>();

    private String name;

    private Class index;

    public Section(ComponentClassResolver resolver, String name, Class... pages) {
        assert pages.length > 0;
        this.resolver = resolver;
        this.name = name;
        this.index = pages[0];
        for (Class page : pages) {
            this.pages.add(resolver.resolvePageClassNameToPageName(page.getName()));
        }
    }

    public String getIndex() {
        return resolver.resolvePageClassNameToPageName(index.getName());
    }

    public String getName() {
        return name;
    }


}
