package com.financeactive.training.components;

import com.financeactive.training.services.Section;
import com.financeactive.training.services.Sections;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.PersistentLocale;

import java.util.Locale;

/**
 * Layout component for pages of application training.
 */
@Import(stylesheet = {"context:bootstrap/css/bootstrap.css",
                      "context:layout/layout.css"}
        , library = {"context:js/demo.js"}
//        ,stack = "training-stack"
)
public class Layout {
    @Property
    @Inject
    @Symbol(SymbolConstants.TAPESTRY_VERSION)
    private String tapestryVersion;

    /**
     * The page title, for the <title> element and the <h1> element.
     */
    @Property
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String title;

    @Property
    private String pageName;

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String sidebarTitle;

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private Block sidebar;

    @Inject
    private ComponentResources resources;

    @Inject
    private Sections sections;

    @Property
    private Section section;

    @Property
    @Inject
    @Symbol(SymbolConstants.APPLICATION_VERSION)
    private String appVersion;

    @Inject
    PersistentLocale persistentLocale;


    public String getClassForPageName() {
        return resources.getPageName().equalsIgnoreCase(pageName)
               ? "current_page_item"
               : null;
    }

    public String getClassForSection() {
        String pageName1 = resources.getPageName();
        return section.contains(pageName1)
               ? "active"
               : null;
    }

    public Iterable<Section> getSections() {
        return sections.entries();
    }

    public String[] getPageNames() {
        return new String[]{"Index", "Guess", "Users", "About", "Contact"};
    }

    public String getCurrentPage() {
        return resources.getPageName();
    }

    @OnEvent(value = EventConstants.ACTION, component = "toggleLocal")
    public void onToggle() {
        persistentLocale.set(Locale.FRENCH.equals(persistentLocale.get()) ? Locale.ENGLISH : Locale.FRENCH);
    }

    public String getLocaleName() {
        if (persistentLocale.isSet()) {
            return persistentLocale.get().getLanguage();
        } else {
            return "";
        }
    }
}
