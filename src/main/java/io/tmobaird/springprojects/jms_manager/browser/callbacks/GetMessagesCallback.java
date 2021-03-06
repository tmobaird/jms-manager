package io.tmobaird.springprojects.jms_manager.browser.callbacks;

import io.tmobaird.springprojects.jms_manager.SimpleTextMessage;
import org.springframework.jms.core.BrowserCallback;

import javax.jms.JMSException;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class GetMessagesCallback  implements BrowserCallback<List<SimpleTextMessage>> {
    @Override
    public List<SimpleTextMessage> doInJms(Session session, QueueBrowser browser) throws JMSException {
        Enumeration<TextMessage> messages = browser.getEnumeration();
        List<SimpleTextMessage> textMessages = new ArrayList<>();

        while (messages.hasMoreElements()) {
            TextMessage m = messages.nextElement();
            SimpleTextMessage message = textMessageToSimpleTextMessage(m);
            textMessages.add(message);
        }

        return textMessages;
    }

    private SimpleTextMessage textMessageToSimpleTextMessage(TextMessage textMessage) throws JMSException {
        SimpleTextMessage message = new SimpleTextMessage();
        message.setId(textMessage.getJMSMessageID());
        message.setCorrelationId(textMessage.getJMSCorrelationID());
        message.setTimestamp(textMessage.getJMSTimestamp());
        message.setText(textMessage.getText());
        return message;
    }
}
