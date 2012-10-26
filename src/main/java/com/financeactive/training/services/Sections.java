package com.financeactive.training.services;

import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.UsesOrderedConfiguration;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jvedikunnel
 * Date: 26/10/12
 * Time: 10:02
 */
@UsesOrderedConfiguration(Section.class)
public class Sections {

    @Inject
    public Messages messages;

    private List<Section> sections;

    public Sections(List<Section> sections) {
        this.sections = sections;
    }

    public Iterable<Section> entries() {
        return sections;
    }
}
