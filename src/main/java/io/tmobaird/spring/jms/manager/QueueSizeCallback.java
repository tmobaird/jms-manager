package io.tmobaird.spring.jms.manager;

import org.springframework.jms.core.BrowserCallback;

import javax.jms.JMSException;
import javax.jms.QueueBrowser;
import javax.jms.Session;

class QueueSizeCallback implements BrowserCallback<Integer> {

    @Override
    public Integer doInJms(Session session, QueueBrowser browser) throws JMSException {
        return 1;
    }
}
