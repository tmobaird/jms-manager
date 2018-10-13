package io.tmobaird.spring.jms.manager.browser.callbacks;

import org.springframework.jms.core.BrowserCallback;

import javax.jms.JMSException;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

public class QueueSizeCallback implements BrowserCallback<Integer> {

    @Override
    public Integer doInJms(Session session, QueueBrowser browser) throws JMSException {
        Integer bytes = 0;

        Enumeration<?> messageList = browser.getEnumeration();

        while (messageList.hasMoreElements()) {
            TextMessage message = TextMessage.class.cast(messageList.nextElement());
            try {
                final byte[] utf8Bytes = message.getText().getBytes("UTF-8");
                bytes += utf8Bytes.length;
            } catch (UnsupportedEncodingException e) {
                System.out.println("CAUGHT EXCEPTION");
            }
        }

        return bytes;
    }
}
