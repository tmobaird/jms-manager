package io.tmobaird.springprojects.jms_manager;

import io.tmobaird.springprojects.jms_manager.browser.callbacks.GetMessagesCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;
import java.util.List;

@Service
public class QueueMessageService {
    private JmsTemplate template;

    @Autowired
    public QueueMessageService(JmsTemplate template) {
        this.template = template;
    }

    public List<TextMessage> getMessages(String queueName) {
        return template.browse(queueName, new GetMessagesCallback());
    }
}
