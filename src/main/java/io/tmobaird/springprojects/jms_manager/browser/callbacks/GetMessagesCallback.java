package io.tmobaird.springprojects.jms_manager.browser.callbacks;

import org.springframework.jms.core.BrowserCallback;

import javax.jms.JMSException;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.ArrayList;
import java.util.List;

public class GetMessagesCallback  implements BrowserCallback<List<TextMessage>> {
    @Override
    public List<TextMessage> doInJms(Session session, QueueBrowser browser) throws JMSException {
        return new ArrayList<>();
    }
}
