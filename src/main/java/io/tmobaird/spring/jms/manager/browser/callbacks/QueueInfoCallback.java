package io.tmobaird.spring.jms.manager.browser.callbacks;

import io.tmobaird.spring.jms.manager.QueueInfo;
import org.springframework.jms.core.BrowserCallback;

import javax.jms.JMSException;
import javax.jms.QueueBrowser;
import javax.jms.Session;

public class QueueInfoCallback implements BrowserCallback<QueueInfo> {
    @Override
    public QueueInfo doInJms(Session session, QueueBrowser browser) throws JMSException {
        return new QueueInfo("Name", 1, 2);
    }
}
