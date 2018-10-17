package io.tmobaird.springprojects.jms_manager;

import io.tmobaird.springprojects.jms_manager.browser.callbacks.GetMessageCallback;
import io.tmobaird.springprojects.jms_manager.browser.callbacks.GetMessagesCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.List;

@Service
public class QueueMessageService {
    private JmsTemplate template;

    @Autowired
    public QueueMessageService(JmsTemplate template) {
        this.template = template;
    }

    public List<SimpleTextMessage> getMessages(String queueName) {
        return template.browse(queueName, new GetMessagesCallback());
    }

    public SimpleTextMessage getMessage(String queueName, String messageId) {
        GetMessageCallback callback = new GetMessageCallback();
        return template.browseSelected(queueName, getMessageSelector(messageId), callback);
    }

    public void deleteMessage(String queueName, String messageId) {
        template.setReceiveTimeout(1000);

        // Automatically acknowledges the message
        Message m = template.receiveSelected(queueName, getMessageSelector(messageId));

        try {
            System.out.println(String.format("Message with id %s deleted", m.getJMSMessageID()));
        } catch (JMSException | NullPointerException e) {
            System.out.println("Should cause a 404 to return");
        }
    }

    private String getMessageSelector(String jmsMessageId) {
        return "JMSMessageID='" + jmsMessageId + "'";
    }
}
