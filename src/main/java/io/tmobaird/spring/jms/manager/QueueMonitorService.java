package io.tmobaird.spring.jms.manager;

import io.tmobaird.spring.jms.manager.browser.callbacks.MessageCountCallback;
import io.tmobaird.spring.jms.manager.browser.callbacks.QueueInfoCallback;
import io.tmobaird.spring.jms.manager.browser.callbacks.QueueSizeCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class QueueMonitorService {
    private JmsTemplate template;

    @Autowired
    public QueueMonitorService(JmsTemplate template) {
        this.template = template;
    }

    public QueueInfo getQueueInfo(String name) {
        QueueInfoCallback callback = new QueueInfoCallback();
        return template.browse(name, callback);
    }

    public Integer getNumberOfMessagesInQueue(String name) {
        MessageCountCallback callback = new MessageCountCallback();
        return template.browse(name, callback);
    }

    public Integer getQueueSize(String name) {
        QueueSizeCallback callback = new QueueSizeCallback();
        return template.browse(name, callback);
    }
}
