package io.tmobaird.spring.jms.manager;

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

    QueueInfo getQueueInfo(String name) {
        MessageCountCallback countCallback = new MessageCountCallback();
        Integer messageCount = template.browse(name, countCallback);

        QueueSizeCallback sizeCallback = new QueueSizeCallback();
        Integer queueSize = template.browse(name, sizeCallback);

        return new QueueInfo(name, messageCount, queueSize);
    }
}
