package com.financeactive.training.pages;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;


public class Contact {
    @Inject
    private Messages messages;

    @PageActivationContext // persisté dans contexte ex : contact/1
    //@ActivationRequestParameter("bid")  // parametre persisté ex : contact?bid=1
    private int blockId;

    @Inject
    private Block block1, block2;

    public Class onActivate() {
        if (blockId == 0) {
            blockId = 1;
//            return Index.class;
        }
        return null;
    }

    public String getName() {
        return messages.get("nom");
    }

    public Block getActiveBlock() {
        if (blockId == 1) {
            return block1;
        } else {
            return block2;
        }
    }

    @OnEvent(EventConstants.PROGRESSIVE_DISPLAY)
    public Block onDisplay() throws InterruptedException {
        Thread.sleep(2000);
        return block2;
    }

    public String getTheGrandTotal() throws InterruptedException {
        return "42";
    }
}
