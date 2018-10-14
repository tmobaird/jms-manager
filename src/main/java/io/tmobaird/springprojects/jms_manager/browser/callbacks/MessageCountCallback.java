package io.tmobaird.springprojects.jms_manager.browser.callbacks;

import org.springframework.jms.core.BrowserCallback;

import javax.jms.JMSException;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import java.util.Collections;

public class MessageCountCallback implements BrowserCallback<Integer> {

    @Override
    public Integer doInJms(Session session, QueueBrowser browser) throws JMSException {
        browser.getQueue();

        return Collections.list(browser.getEnumeration()).size();
    }
}
