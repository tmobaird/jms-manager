package io.tmobaird.springprojects.jms_manager.browser.callbacks;

import io.tmobaird.springprojects.jms_manager.QueueInfo;
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
