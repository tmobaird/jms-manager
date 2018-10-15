package io.tmobaird.springprojects.jms_manager.browser.callbacks;

import io.tmobaird.springprojects.jms_manager.SimpleTextMessage;
import org.springframework.jms.core.BrowserCallback;

import javax.jms.*;
import java.util.Enumeration;

public class GetMessageCallback implements BrowserCallback<SimpleTextMessage> {
    @Override
    public SimpleTextMessage doInJms(Session session, QueueBrowser browser) throws JMSException {
        Enumeration<TextMessage> messages = browser.getEnumeration();

        TextMessage textMessage = messages.nextElement();

        if (textMessage != null) {
            return textMessageToSimpleTextMessage(textMessage);
        } else {
            throw new JMSException("No element found matching selector");
        }
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
