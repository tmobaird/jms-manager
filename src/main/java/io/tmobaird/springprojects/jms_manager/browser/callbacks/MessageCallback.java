package io.tmobaird.springprojects.jms_manager.browser.callbacks;

import org.springframework.jms.core.BrowserCallback;

import javax.jms.*;
import java.util.Enumeration;

public class MessageCallback implements BrowserCallback<TextMessage> {
    @Override
    public TextMessage doInJms(Session session, QueueBrowser browser) throws JMSException {
        Enumeration<TextMessage> messages = browser.getEnumeration();
        return messages.nextElement();
    }
}
