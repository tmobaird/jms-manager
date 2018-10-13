package io.tmobaird.spring.jms.manager;

import io.tmobaird.spring.jms.manager.browser.callbacks.QueueSizeCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import io.tmobaird.spring.jms.manager.browser.callbacks.MessageCountCallback;

@Service
public class QueueMonitorService {
    private JmsTemplate template;

    @Autowired
    public QueueMonitorService(JmsTemplate template) {
        this.template = template;
    }

    public QueueInfo getQueueInfo(String name) {
        MessageCountCallback countCallback = new MessageCountCallback();
        Integer messageCount = template.browse(name, countCallback);

        QueueSizeCallback sizeCallback = new QueueSizeCallback();
        Integer queueSize = template.browse(name, sizeCallback);

        return new QueueInfo(name, messageCount, queueSize);
    }
}
